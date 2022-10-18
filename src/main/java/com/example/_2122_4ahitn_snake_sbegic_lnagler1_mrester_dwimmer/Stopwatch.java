package com.example._2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer;

public class Stopwatch {
    private long startTime;
    private long stopTime;

    /**
     * starting the stop watch.
     */
    public void start() {
        startTime = System.nanoTime();
    }

    /**
     * stopping the stop watch.
     */
    public void stop() {
        stopTime = System.nanoTime();
    }

    /**
     * elapsed time in nanoseconds.
     */
    public long time() {
        return (stopTime - startTime);
    }

    public String toString() {
        return "elapsed time: " + time() + " nanoseconds.";
    }
}