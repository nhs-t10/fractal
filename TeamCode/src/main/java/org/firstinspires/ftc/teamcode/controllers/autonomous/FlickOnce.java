package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.tests.Stall;
import org.firstinspires.ftc.teamcode.organs.Flicker;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TEncoderMotor;
import org.firstinspires.ftc.teamcode.tissues.TMotor;

/**
 * Created by robotics on 11/15/16.
 */
public class FlickOnce implements Controller {
    private Flicker flicker;
    private boolean useEnc = false;
    private Stall wait = new Stall(925);

    public FlickOnce(Flicker fl) {
        this(fl, fl.usesEncoder());
    }

    public FlickOnce(Flicker fl, boolean encoder) {
        useEnc = encoder;
        flicker = fl;
    }

    @Override
    public boolean tick() {
        if(useEnc) {
            return flicker.flick360();
        }
        else {
            if(wait.tick()) {
                flicker.stop();
                return true;
            }
            flicker.engage();
            return false;
        }
    }
}