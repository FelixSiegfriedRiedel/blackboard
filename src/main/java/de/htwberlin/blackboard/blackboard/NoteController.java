package de.htwberlin.blackboard.blackboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
public class NoteController {


    @Autowired
    private NoteService noteService;


    @PostMapping("/notes")
    public Note addNote(@RequestBody Note note) {
        long millisProTag = 24L * 60L * 60L * 1000L; // 24 Stunden in Millisekunden
        note.setTerminationDate(new java.util.Date(System.currentTimeMillis() + millisProTag));
        note.setCreationDate( new java.util.Date());
        Note saved = noteService.save(note);
        System.out.println("Note erhalten: " + note.getTitle() + " " + note.getId());
        return saved;
    }

    @GetMapping("/notes/{id}")
    public Note getNote(@PathVariable String id) {
        Long noteId = Long.parseLong(id);
        return noteService.get(noteId);
    }

    @GetMapping("/notes")
    public List<Note> getNotes() {
        return noteService.getAll();
    }

    @DeleteMapping("/notes/{id}")
    public void deleteNote(@PathVariable String id) {
        Long noteId = Long.parseLong(id);
        System.out.println("Note löschen: " + noteId);
        noteService.delete(noteId);
    }
    @PutMapping("/notes/{id}")
    public void updateNote(@RequestBody Note updatedNote, @PathVariable String id) {
        Long noteId = Long.parseLong(id);
        System.out.println("Note ändern: " + noteId);
        noteService.updateNote(updatedNote, noteId);
    }
    /**
     * check every minute if there are notes that have expired
     * maybe change to one time a day
     */
    @Scheduled(fixedRate = 60000)
    public void checkAndDeleteExpiredNotes() {
        List<Note> allNotes = noteService.getAll();
        Date currentTime = new Date();

        for (Note note : allNotes) {
            if (note.getTerminationDate() != null &&
                    note.getTerminationDate().before(currentTime)) {
                noteService.delete(note.getId());
                System.out.println("Abgelaufene Notiz gelöscht: " + note.getId());
                 }
             }
        }
    }
