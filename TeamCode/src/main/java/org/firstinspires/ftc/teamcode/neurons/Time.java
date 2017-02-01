package org.firstinspires.ftc.teamcode.neurons;

import org.firstinspires.ftc.teamcode.debug.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by robotics on 11/15/16.
 */
public class Time {
    public static long getTimeMillis() {
        return System.currentTimeMillis();
    }

    public static String getDateStr() {
        return getDateStr("yyyy-MM-dd_HH:mm:ss");
    }

    public static String getDateStr(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(new Date());
    }

    public static void sleep(int millis) {
        Logger.logLine("This function intended for debugging only. Please use Stopwatch instead.");
        long length = (long)millis;
        try {
            Thread.sleep(length);
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public static class Stopwatch {
        private long startTime;
        private boolean recording = false;

        public void start() {
            if (!recording) {
                reset();
                recording = true;
            }
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