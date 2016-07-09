package com.qualcomm.ftcrobotcontroller.controllers.teleop;

import com.qualcomm.ftcrobotcontroller.controllers.Controller;
import com.qualcomm.ftcrobotcontroller.debug.Logger;
import com.qualcomm.ftcrobotcontroller.neurons.HumanDriving;
import com.qualcomm.ftcrobotcontroller.organs.DriveTrain;
import com.qualcomm.ftcrobotcontroller.statics.ControlParser;
import com.qualcomm.ftcrobotcontroller.statics.Controls;

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

    public boolean tick() {
        ArrayList<Float> joyValues = ControlParser.range(Controls.JoyDrive);
        ArrayList<Float> powers = HumanDriving.joyToPowers(joyValues);
        float pL = powers.get(0);
        float pR = powers.get(1);
        if(powers.get(0) == 0 && powers.get(1) == 0 && prevPowerL != 0 && prevPowerR != 0) {
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
