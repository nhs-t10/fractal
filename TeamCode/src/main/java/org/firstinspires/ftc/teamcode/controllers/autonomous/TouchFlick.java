package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.tests.Stall;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.Time;
import org.firstinspires.ftc.teamcode.organs.Flicker;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TTouch;

/**
 * Created by robotics on 11/15/16.
 */
public class TouchFlick implements Controller {
    private Flicker flicker;
    private TTouch touch = new TTouch(Hardware.Touch);
    private Time.Stopwatch sw = new Time.Stopwatch();
    private Time.Stopwatch timeoutTimer = new Time.Stopwatch();

    private boolean initialHit = false;
    private int delay;
    private int timeout;

    public TouchFlick(Flicker fl) {
        this(fl, -1, -1);
    }

    public TouchFlick(Flicker fl, int d) {
        this(fl, d, -1);
    }

    public TouchFlick(Flicker fl, int d, int t) {
        flicker = fl;
        delay = d;
        timeout = t;
    }

    @Override
    public boolean tick() {
        if(touch.isPressed()) {
            flicker.engage();
            flicker.lock(true);
            initialHit = true;
            return false;
        }

        //when touch sensor unpressed, keep going for delay, then stop
        if(initialHit && !sw.isRecording()) {
            sw.start();
        } else if(initialHit && sw.timeElapsed() > delay) {
            deinit();
            return true;
        }

        //kill macro if takes to long
        //off by default
        if(!timeoutTimer.isRecording()) {
            timeoutTimer.start();
        } else if(timeout >= 0 && !initialHit && timeoutTimer.timeElapsed() > timeout) {
            Logger.logLine("Macro ran out of time!");
            deinit();
            return true;
        }

        return false;
    }

    private void deinit() {
        flicker.stop();
        flicker.lock(false);
        sw.stop();
        timeoutTimer.stop();
        initialHit = false;
    }
}