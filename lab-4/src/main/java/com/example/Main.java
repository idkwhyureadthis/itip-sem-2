package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Player abPlayer = new Player(context.getBean("audioBook", Book.class));
        Player mPlayer = new Player(context.getBean("musical", Book.class));
        Player movPlayer = new Player(context.getBean("movie", Book.class));


        abPlayer.Play();
        abPlayer.Stop(); 

        mPlayer.Play();   
        mPlayer.Stop();    

        movPlayer.Play();
        movPlayer.Stop();

        context.close();
    }
}   