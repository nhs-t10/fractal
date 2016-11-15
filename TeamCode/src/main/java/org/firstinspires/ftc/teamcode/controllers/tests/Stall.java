package org.firstinspires.ftc.teamcode.controllers.tests;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.neurons.Time;

/**
 * Created by robotics on 11/14/16.
 */
public class Stall implements Controller {
    private Time.Stopwatch stopwatch;
    private int time;
    private boolean forever;

    public Stall() {
        forever = true;
        time = 0;
        stopwatch = new Time.Stopwatch();
    }

    public Stall(int millis) {
        forever = false;
        time = millis;
        stopwatch = new Time.Stopwatch();
    }

    @Override
    public boolean tick() {
        if(!stopwatch.isRecording()) {
            stopwatch.start();
        }

        if(!forever && stopwatch.timeElapsed() > time) {
            stopwatch.stop();
            return true;
        }

        return false;
    }
}
