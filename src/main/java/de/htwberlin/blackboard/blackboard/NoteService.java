package de.htwberlin.blackboard.blackboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    NoteRepository repo;

    public Note save(Note note) {
        return repo.save(note);
    }

    public Note get(Long id) {
        return repo.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Note> getAll() {
        return (List<Note>) repo.findAll();
    }
}
