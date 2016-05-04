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
public class OneStickDrive implements Controller {
    private DriveTrain drivetrain;

    public OneStickDrive(DriveTrain dt) {
        drivetrain = dt;
    }

    public boolean tick() {
        ArrayList<Float> joyValues = ControlParser.range(Controls.JoyDrive);
        ArrayList<Float> powers = HumanDriving.JoyToDirection(joyValues);

        drivetrain.drive(powers.get(0), powers.get(1));
        return false;
    }
}
