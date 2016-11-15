package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TMotor;

/**
 * Created by robotics on 11/15/16.
 */
public class FlickOnce implements Controller {
    TMotor fl;

    public FlickOnce() {
        fl = new TMotor(Hardware.Flicker);
    }

    @Override
    public boolean tick() {
        return fl.moveFor(1.0f, 1000);
    }
}
