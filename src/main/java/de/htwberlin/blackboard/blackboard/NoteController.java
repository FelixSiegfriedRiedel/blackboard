package de.htwberlin.blackboard.blackboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class NoteController {


    @Autowired
    private NoteService noteService;


    @PostMapping("/notes")
    public Note addNote(@RequestBody Note note) {
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
}
