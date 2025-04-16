package de.htwberlin.blackboard.blackboard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoteController {

    @GetMapping("/notes")
    public List<Note> testRoute() {
        return List.of(
                new Note("Konzert 10.05. im Fischladen", "3 Bands, Punk, Rock, 10€", "Fischer"),
                new Note("Konzert 15.05. im Fischladen", "3 Bands, Punk, Rock, 10€", "Fischer"),
                new Note("Konzert 15.05. im Fischladen", "3 Bands, Punk, Rock, 10€", "Fischer")
        );
    }
}
