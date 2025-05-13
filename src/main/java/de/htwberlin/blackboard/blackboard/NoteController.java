package de.htwberlin.blackboard.blackboard;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "https://blackboard-frontend-inaa.onrender.com")
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
        System.out.println("Note erhalten: " + note.getTitle());
        notes.add(note);
    }
}
