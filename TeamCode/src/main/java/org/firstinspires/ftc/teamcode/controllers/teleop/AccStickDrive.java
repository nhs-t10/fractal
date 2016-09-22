package org.firstinspires.ftc.teamcode.controllers.teleop;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.HumanDriving;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;
import org.firstinspires.ftc.teamcode.statics.ControlParser;
import org.firstinspires.ftc.teamcode.statics.Controls;

import java.util.ArrayList;

/**
 * Created by max on 4/17/16.
 */
public class AccStickDrive implements Controller {
    private DriveTrain drivetrain;
    private float prevPowerL = 0;
    private float prevPowerR = 0;
    private final float interval = 0.01f;
    public AccStickDrive(DriveTrain dt) {
        drivetrain = dt;
        Logger.logLine("Initialized stick drive.");
    }

    //future implementation: if(abs(prevPower - curPower) > interval)) power = power +/- interval;

    public boolean tick() {
        ArrayList<Float> joyValues = ControlParser.range(Controls.JoyDrive);
        ArrayList<Float> powers = HumanDriving.joyToPowers(joyValues);
        float pL = powers.get(0);
        float pR = powers.get(1);
        if(powers.get(0) == 0 && powers.get(1) == 0 && prevPowerL != 0 && prevPowerR != 0) { //if jump to 0, decrease
            pL = prevPowerL - interval;
            pR = prevPowerR - interval;
        }
        prevPowerL = pL;
        prevPowerR = pR;
        Logger.logLine("" + prevPowerL);
        drivetrain.drive(pL, pR);

        return false;
    }
}
