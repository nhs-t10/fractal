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

    public FlickOnce() {
        fl = new TMotor(Hardware.Flicker);
        efl = new TEncoderMotor(Hardware.Flicker);
    }

    @Override
    public boolean tick() {
        return efl.rotate360(1);
    }
}
