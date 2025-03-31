package com.example;

public class Musical extends Book {
    protected String producer;

    public Musical(String name, String author, String producer) {
        this.author = author;
        this.name = name;
        this.producer = producer;
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