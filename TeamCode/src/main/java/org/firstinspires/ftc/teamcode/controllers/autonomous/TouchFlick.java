package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.tests.Stall;
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

    private boolean initialHit = false;
    private int delay;

    public TouchFlick(Flicker fl) {
        this(fl, -1);
    }

    public TouchFlick(Flicker fl, int d) {
        flicker = fl;
        delay = d;
    }

    @Override
    public boolean tick() {
        if(touch.isPressed()) {
            flicker.engage();
            initialHit = true;
            return false;
        }

        //when touch sensor unpressed, keep going for delay, then stop
        if(initialHit && !sw.isRecording()) {
            sw.start();
        } else if(initialHit && sw.timeElapsed() > delay) {
            flicker.stop();
            sw.stop();
            initialHit = false;
            return true;
        }

        return false;
    }
}