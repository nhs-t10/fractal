package org.firstinspires.ftc.teamcode.organs;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.lib.Sleep;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TEncoderMotor;
import org.firstinspires.ftc.teamcode.tissues.TMotor;

/**
 * Created by robotics on 9/22/16.
 *
 * Handles both encoder and non-encoder activities.
 */
public class Flicker implements Component {
    private TEncoderMotor EFlicker;
    private TMotor flicker;
    private boolean on = false;
    private int dir;
    private boolean usesEncoder = false;
    public Flicker(boolean encoder, int d) {
        if(!encoder) flicker = new TMotor(Hardware.Flicker);
        else EFlicker = new TEncoderMotor(Hardware.Flicker);
        usesEncoder = encoder;
        dir = d;
    }

    public boolean usesEncoder() {
        return usesEncoder;
    }

    public void toggle() {
        if (on) stop();
        else engage();
        on = !on;
    }
    public void stop() {
        flicker.stop();
    }
    public void engage() {
        flicker.move(dir * 1.0f);
    }
    public boolean flick360() {
        if(EFlicker != null) {
            return EFlicker.rotate360(1);
        }
        Logger.logLine("ERROR: calling an encoder method on a non-encoder flicker.");
        return false;
    }

    private boolean lockedstate = false;

    public void lock(boolean status) {
        lockedstate = status;
    }

    public boolean inUse() {
        return lockedstate;
    }

    @Deprecated
    public void flick() {
        Logger.logLine("Flicking");
        //flicker.rotate360(1);
        Logger.logLine("Flicked");
    }

    public String getName() {
        return "Ball Flicker";
    }

    public boolean test() {
        toggle();
        Sleep.secs(3);
        toggle();
        return false;
    }
}
