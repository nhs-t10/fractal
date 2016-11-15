package org.firstinspires.ftc.teamcode.neurons;

/**
 * Created by robotics on 11/15/16.
 */
public class Time {
    public static long getTimeMillis() {
        return System.currentTimeMillis();
    }

    public static class Stopwatch {
        private long startTime;
        private boolean recording = false;

        public void start() {
            recording = true;
            reset();
        }

        public void stop() {
            recording = false;
        }

        public boolean isRecording() {
            return recording;
        }

        public void reset() {
            startTime = getTimeMillis();
        }

        public long getStartTime() {
            return startTime;
        }

        public long timeElapsed() {
            return getTimeMillis() - startTime;
        }
    }
}