package com.example;

public class Musical implements Book {
    protected String producer;

    protected String author;
    protected String name;
    protected boolean isRunning;

    public Musical(String name, String author, String producer) {
        this.author = author;
        this.name = name;
        this.producer = producer;
    }

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

    public Musical(Book book, String producer) {
        this(book.getName(), book.getAuthor(), producer);
    }

    @Override
    public String start() {
        if (isRunning) {
            return "Musical already started";
        }
        isRunning = true;
        return String.format("Musical '%s' started", name);
    }

    @Override
    public String stop() {
        if (!isRunning) {
            return "Musical already stopped";
        }
        isRunning = false;
        return String.format("Musical '%s' stopped", name);
    }

    public void setProducer(String newProducer) {
        producer = newProducer;
    }

    public String getProducer() {
        return producer;
    }


}