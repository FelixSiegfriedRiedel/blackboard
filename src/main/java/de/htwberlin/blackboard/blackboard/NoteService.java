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
    public void delete(Long id) {
        repo.deleteById(id);
    }
    public void updateNote(Note updatedNote, Long id) {
        repo.findById(id)
                .map(existingNote -> {
                    existingNote.setTitle(updatedNote.getTitle());
                    existingNote.setContent(updatedNote.getContent());
                    existingNote.setxPosition(updatedNote.getxPosition());
                    existingNote.setyPosition(updatedNote.getyPosition());
                    return repo.save(existingNote);
                })
                .orElseGet(() -> {
                    return repo.save(updatedNote);
                });
    }
}