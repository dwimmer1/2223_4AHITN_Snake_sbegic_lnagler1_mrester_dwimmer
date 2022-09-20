package com.example._2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.FactoryRegistry;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Musicplayer {
    private AdvancedPlayer player;

    public Musicplayer() {

    }

    public void playFile(String filename) {
        try {
            preparePlayer(filename);
            player.play(500);
        } catch (JavaLayerException e) {
            error(filename);
        } finally {
            killPlayer();
        }
    }

    public void startPlaying(final String filename) {
        try {
            preparePlayer(filename);
            Thread playerThread = new Thread() {
                public void run() {
                    try {
                        player.play();
                    } catch (JavaLayerException e) {
                        error(filename);
                    } finally {
                        killPlayer();
                    }
                }
            };
            playerThread.start();
        } catch (Exception ex) {
            error(filename);
        }
    }

    public void stop() {
        killPlayer();
    }

    private void preparePlayer(String filename) {
        try {
            InputStream is = getInputStream(filename);
            player = new AdvancedPlayer(is, createAudioDevice());
        } catch (IOException e) {
            error(filename);
            killPlayer();
        } catch (JavaLayerException e) {
            error(filename);
            killPlayer();
        }
    }

    private InputStream getInputStream(String filename)
            throws IOException {
        return new BufferedInputStream(
                new FileInputStream(filename));
    }

    private AudioDevice createAudioDevice()
            throws JavaLayerException {
        return FactoryRegistry.systemRegistry().createAudioDevice();
    }

    private void killPlayer() {
        synchronized (this) {
            if (player != null) {
                player.stop();
                player = null;
            }
        }
    }

    private void error(String filename) {
        System.out.println("A Error occurred while playing: " + filename);
    }

}
