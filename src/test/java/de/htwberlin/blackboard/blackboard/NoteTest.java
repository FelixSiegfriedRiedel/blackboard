package de.htwberlin.blackboard.blackboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class NoteTest {

     Note testNote;
      String TEST_NAME = "TestNote";
      String TEST_CONTENT = "TestContent";
      String TEST_AUTHOR = "TestAuthor";
      String TEST_COLOR = "yellow";
      int TEST_X_POS = 100;
      int TEST_Y_POS = 200;
      int TEST_WIDTH = 300;
      int TEST_HEIGHT = 400;
      Date TEST_DATE = new Date();

    @BeforeEach
    void setUp() {
        testNote = new Note(TEST_NAME, TEST_CONTENT, TEST_AUTHOR,
                TEST_X_POS, TEST_Y_POS, TEST_DATE, TEST_COLOR);
        testNote.setId(1L);
        testNote.setWidth(TEST_WIDTH);
        testNote.setHeight(TEST_HEIGHT);
    }

    @Test
    void testNoteConstructor() {
        assertNotNull(testNote);
        assertEquals(TEST_NAME, testNote.getTitle());
        assertEquals(TEST_CONTENT, testNote.getContent());
        assertEquals(TEST_AUTHOR, testNote.getAuthor());
        assertEquals(TEST_X_POS, testNote.getXPosition());
        assertEquals(TEST_Y_POS, testNote.getYPosition());
        assertEquals(TEST_COLOR, testNote.getColor());
        assertEquals(TEST_DATE, testNote.getCreationDate());
    }

    @Test
    void testToString() {
        String expectedString = String.format("{id=%d, title='%s', content='%s', author='%s', " +
                        "color='%s', creationDate=%s, terminationDate=%s, xPosition=%d, yPosition=%d, " +
                        "width=%d, height=%d}",
                testNote.getId(), TEST_NAME, TEST_CONTENT, TEST_AUTHOR, TEST_COLOR,
                TEST_DATE, null, TEST_X_POS, TEST_Y_POS, TEST_WIDTH, TEST_HEIGHT);

        assertEquals(expectedString, testNote.toString());
        System.out.println(testNote.toString());
    }
}