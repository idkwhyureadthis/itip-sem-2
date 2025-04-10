package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AudioClip;
import java.awt.print.Book;

import org.springframework.context.ApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        AudioBook audioBook = context.getBean("audioBook", AudioBook.class);
        Musical musical = context.getBean("musical", Musical.class);
        Movie movie = context.getBean("movie", Movie.class);


        System.out.println(audioBook.start());
        System.out.println(audioBook.stop()); 

        System.out.println(musical.start());   
        System.out.println(musical.stop());    

        System.out.println(movie.start());
        System.out.println(movie.stop());
    }
}   