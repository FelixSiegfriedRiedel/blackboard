package de.htwberlin.blackboard.blackboard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class NoteServiceTest {

    @Autowired
    private NoteService service;

    @MockitoBean
    private NoteRepository repository;

    @Test
    @DisplayName("should find a Note by its id")
    void testGet() {
        var note = new Note("Test Note", "This is a test note", "Test Author",50 ,100 , new java.util.Date(), new java.util.Date(), "yellow");
        doReturn(Optional.of(note)).when(repository).findById(110L);
        Note actual = service.get(110L);

        assertEquals("Test Author", actual.getAuthor());
    }

}
