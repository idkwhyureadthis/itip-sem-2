package com.example;

public class Movie extends Musical {
    public Movie(String name, String author, String producer) {
        super(name, author, producer);
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