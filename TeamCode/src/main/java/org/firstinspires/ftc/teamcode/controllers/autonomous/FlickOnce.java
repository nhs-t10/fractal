package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TEncoderMotor;
import org.firstinspires.ftc.teamcode.tissues.TMotor;

/**
 * Created by robotics on 11/15/16.
 */
public class FlickOnce implements Controller {
    TMotor fl;
    TEncoderMotor efl;
    private boolean useEnc = false;

    public FlickOnce() {
        this(false);
    }

    public FlickOnce(boolean encoder) {
        if(encoder) {
            useEnc = true;
            efl = new TEncoderMotor(Hardware.Flicker);
        } else {
            fl = new TMotor(Hardware.Flicker);
        }
    }

    @Override
    public boolean tick() {
        if(useEnc) {
            return efl.rotate360(1);
        }
        return fl.moveFor(1.0f, 220);
    }
}