package com.qualcomm.ftcrobotcontroller.controllers;

import com.qualcomm.ftcrobotcontroller.debug.Logger;
import com.qualcomm.ftcrobotcontroller.neurons.HumanDriving;
import com.qualcomm.ftcrobotcontroller.organs.DriveTrain;
import com.qualcomm.ftcrobotcontroller.organs.TreadDrivetrain;
import com.qualcomm.ftcrobotcontroller.statics.ControlParser;
import com.qualcomm.ftcrobotcontroller.statics.Controls;

import java.util.ArrayList;

/**
 * Created by max on 4/17/16.
 */
public class OneStickDrive {
    /* Hey max, just a brief explanation of what is going on here. I edited the code to allow for
     * any instance of drivetrain to be used with onestick drive as opposed to just TreadDriveTrain.
     * I can explain more in person if you need any more information.
     */

    private static DriveTrain drivetrain;

    public static void init(DriveTrain dt) {
        drivetrain = dt;
    }

    public static void tick() {
        ArrayList<Float> joyValues = ControlParser.range(Controls.JoyDrive);
        ArrayList<Float> powers = HumanDriving.JoyToDirection(joyValues);

        Logger.logLine("" + powers.get(0) + ", " + powers.get(1));
        drivetrain.drive(powers.get(0), powers.get(1));
        Logger.logLine("left: " + Float.toString(powers.get(0)));
    }
}
