package de.htwberlin.blackboard.blackboard;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class NoteController {

    private final List<Note> notes = new ArrayList<>();

    public NoteController() {
        notes.add(new Note(
                "Konzert 10.05. im Fischladen",
                "3 Bands, Punk, Rock, 10€",
                "Fischer",
                200,
                100
                ));
        notes.add(new Note("Konzert 15.05. im Fischladen", "3 Bands, Punk, Rock, 10€", "Fischer", 500, 400));
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
