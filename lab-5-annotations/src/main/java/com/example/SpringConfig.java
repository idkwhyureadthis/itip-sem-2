package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example")
public class SpringConfig {
    
    @Bean(name="audioBook")
    public AudioBook audioBook() {
        return new AudioBook("1984", "George Orwell", "John Smith");
    }
    
    @Bean(name="musical")
    public Musical musical() {
        return new Musical("The Phantom of the Opera", "Andrew Lloyd Webber", "Cameron Mackintosh");
    }
    
    @Bean(name="movie")
    public Movie movie() {
        return new Movie("Inception", "Christopher Nolan", "Emma Thomas");
    }
    
    @Bean(name="audioBookPlayer")
    public Player audioBookPlayer() {
        return new Player(audioBook());
    }
    
    @Bean(name="musicalPlayer")
    public Player musicalPlayer() {
        return new Player(musical());
    }
    
    @Bean(name="moviePlayer")
    public Player moviePlayer() {
        return new Player(movie());
    }
}