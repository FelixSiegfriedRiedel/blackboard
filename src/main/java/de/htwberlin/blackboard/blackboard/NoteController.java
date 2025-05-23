package de.htwberlin.blackboard.blackboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;


@RestController
public class NoteController {


    @Autowired
    private NoteService noteService;

    @PostMapping("/notes")
    public Note addNote(@RequestBody Note note) {
        note.setCreationDate( new java.util.Date());
        System.out.println("Note erhalten: " + note.getTitle());
        return noteService.save(note);
    }
//    @GetMapping("/notes/{id}")
//    public void deleteNote(@PathVariable int id) {
//        System.out.println("Note löschen: " + id);
//        notes.removeIf(note -> note.getId() == id);
//    }
    @GetMapping("/notes/{id}")
    public Note getNote(@PathVariable String id) {
        Long noteId = Long.parseLong(id);
        return noteService.get(noteId);
    }

    private final List<Note> notes = new ArrayList<>();

    public NoteController() {
    }

    @GetMapping("/notes")
    public List<Note> getNotes() {
        return noteService.getAll();
    }
}
