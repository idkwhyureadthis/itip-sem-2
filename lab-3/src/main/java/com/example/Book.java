package com.example;

public abstract class Book {
    protected String author;
    protected String name;
    protected boolean isRunning;

    public abstract String start();
    public abstract String stop();

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
}