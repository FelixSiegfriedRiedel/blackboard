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

    public Note(String title, String content, String author, int xPos, int yPos, Date creationDate) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.creationDate = creationDate;
        this.xPosition = xPos;
        this.yPosition = yPos;
    }

    public String getTitle() {
        return title;
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

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
