package de.htwberlin.blackboard.blackboard;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String author;
    private String color;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date creationDate;
    private Date terminationDate;

    private int xPosition;
    private int yPosition;
    private int width;
    private int height;

    public Note() {}

    public Note( String title, String content, String author, int xPos, int yPos, Date creationDate, String color) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.creationDate = creationDate;
        this.xPosition = xPos;
        this.yPosition = yPos;
        this.color = color;
    }

    public String getTitle() {
        return title;
    }


    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getColor() {
        return color;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
