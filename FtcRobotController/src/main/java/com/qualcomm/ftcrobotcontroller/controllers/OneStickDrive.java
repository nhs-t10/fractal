package com.qualcomm.ftcrobotcontroller.controllers;

import com.qualcomm.ftcrobotcontroller.debug.Logger;
import com.qualcomm.ftcrobotcontroller.neurons.HumanDriving;
import com.qualcomm.ftcrobotcontroller.organs.TreadDrivetrain;
import com.qualcomm.ftcrobotcontroller.statics.ControlParser;
import com.qualcomm.ftcrobotcontroller.statics.Controls;

import java.util.ArrayList;

/**
 * Created by max on 4/17/16.
 */
public class OneStickDrive {
    public static void init() {
        TreadDrivetrain.init();
    }
    public static void tick() {
        ArrayList<Float> joyValues = ControlParser.range(Controls.JoyDrive);
        ArrayList<Float> powers = HumanDriving.JoyToDirection(joyValues);
        Logger.logLine("left: " + Float.toString(powers.get(0)));
        TreadDrivetrain.drive(powers.get(0), powers.get(1));
    }
}
