package com.example;

public class Player {
    private Book book;

    public Player(Book book){
        this.book = book;
    }

    public void Play(){
        System.out.println(book.start());
    }

    public void Stop(){
        System.err.println(book.stop());
    }
}
