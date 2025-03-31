package com.example;

public class AudioBook extends Book {
    private String voiceActor;

    public AudioBook(String name, String author, String voiceActor) {
        this.author = author;
        this.name = name;
        this.voiceActor = voiceActor;
    }

    public AudioBook(Book book, String voiceActor) {
        this(book.getName(), book.getAuthor(), voiceActor);
    }

    public String getVoiceActor() {
        return voiceActor;
    }

    public void setVoiceActor(String newVoiceActor) {
        voiceActor = newVoiceActor;
    }

    @Override
    public String start() {
        if (isRunning) {
            return "Audiobook already playing";
        }
        isRunning = true;
        return String.format("Audiobook '%s' playing", name);
    }

    @Override
    public String stop() {
        if (!isRunning) {
            return "Audiobook already stopped";
        }
        isRunning = false;
        return String.format("Audiobook '%s' stopped", name);
    }
}