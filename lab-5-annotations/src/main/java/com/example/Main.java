package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Player abPlayer = context.getBean("audioBookPlayer", Player.class);
        Player mPlayer = context.getBean("musicalPlayer", Player.class);
        Player movPlayer = context.getBean("moviePlayer", Player.class);


        abPlayer.Play();
        abPlayer.Stop(); 

        mPlayer.Play();   
        mPlayer.Stop();    

        movPlayer.Play();
        movPlayer.Stop();

        context.close();
    }
}   