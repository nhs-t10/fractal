package org.firstinspires.ftc.teamcode.controllers.tests;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.Time;
import org.firstinspires.ftc.teamcode.organs.Instruments;

/**
 * Created by robotics on 11/14/16.
 */
public class Stall implements Controller {
    private Time.Stopwatch stopwatch;
    private Instruments i;
    private int time;
    private double target;
    private boolean forever;
    private boolean measuringAngle = false;

    public Stall() {
        forever = true;
        time = 0;
        stopwatch = new Time.Stopwatch();
    }

    public Stall(int millis, double angle, Instruments instruments) {
        i = instruments;
        forever = false;
        time = millis;
        stopwatch = new Time.Stopwatch();
        measuringAngle = true;
        target = angle;
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
        if (measuringAngle){
            Logger.logLine("missed" + (target - i.yaw));
        }
        if(!forever && stopwatch.timeElapsed() > time) {
            stopwatch.stop();
            return true;
        }

        return false;
    }
}
