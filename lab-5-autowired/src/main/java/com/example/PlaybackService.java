package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("playbackService")
public class PlaybackService {

    private final Player audioBookPlayer;
    private final Player musicalPlayer;
    private final Player moviePlayer;

    @Autowired
    public PlaybackService(
            @Qualifier("audioBookPlayer") Player audioBookPlayer,
            @Qualifier("musicalPlayer") Player musicalPlayer,
            @Qualifier("moviePlayer") Player moviePlayer
    ) {
        this.audioBookPlayer = audioBookPlayer;
        this.musicalPlayer = musicalPlayer;
        this.moviePlayer = moviePlayer;
    }

    // Метод для воспроизведения всех медиа
    public void playAll() {
        System.out.println("Playing all media:");
        audioBookPlayer.Play();
        musicalPlayer.Play();
        moviePlayer.Play();
    }

    public void stopAll(){
        System.out.println("Stopping all media:");
        audioBookPlayer.Stop();
        musicalPlayer.Stop();
        moviePlayer.Stop();
    }
}