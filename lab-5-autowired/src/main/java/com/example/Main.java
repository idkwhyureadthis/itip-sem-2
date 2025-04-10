package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        PlaybackService service = context.getBean("playbackService", PlaybackService.class);

        service.playAll();


        service.stopAll();
    }
}   