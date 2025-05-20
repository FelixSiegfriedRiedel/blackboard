package de.htwberlin.blackboard.blackboard;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// @CrossOrigin(origins = "https://blackboard-frontend-inaa.onrender.com")
 @CrossOrigin(origins = "http://localhost:5173")

@RestController
public class NoteController {

    private final List<Note> notes = new ArrayList<>();

    public NoteController() {
    }

    @GetMapping("/notes")
    public List<Note> getNotes() {
        return notes;
    }

    @PostMapping("/notes")
    public void addNote(@RequestBody Note note) {
        note.setCreationDate( new java.util.Date());
        System.out.println("Note erhalten: " + note.getTitle());
        notes.add(note);
    }
    @GetMapping("/notes/{id}")
    public void deleteNote(@PathVariable int id) {
        System.out.println("Note löschen: " + id);
        notes.removeIf(note -> note.getId() == id);
    }
}
