package com.example;

public class Movie implements Book {

    private String producer;
    private String name;
    private String author;
    private boolean isRunning;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String newAuthor) {
        author = newAuthor;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }


    public Movie(String name, String author, String producer) {
        this.name = name;
        this.author = author;
        this.producer = producer;
    }

    public Movie(Book book, String producer) {
        this(book.getName(), book.getAuthor(), producer);
    }

    @Override
    public String start() {
        if (isRunning) {
            return "Movie already started";
        }
        isRunning = true;
        return String.format("Movie '%s' started", name);
    }

    @Override
    public String stop() {
        if (!isRunning) {
            return "Movie already stopped";
        }
        isRunning = false;
        return String.format("Movie '%s' stopped", name);
    }
}