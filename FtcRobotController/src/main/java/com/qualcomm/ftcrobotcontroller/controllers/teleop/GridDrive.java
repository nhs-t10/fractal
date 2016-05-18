package com.qualcomm.ftcrobotcontroller.controllers.teleop;

import com.qualcomm.ftcrobotcontroller.controllers.Controller;
import com.qualcomm.ftcrobotcontroller.debug.Logger;
import com.qualcomm.ftcrobotcontroller.neurons.Cardinal;
import com.qualcomm.ftcrobotcontroller.neurons.HumanDriving;
import com.qualcomm.ftcrobotcontroller.organs.DriveTrain;
import com.qualcomm.ftcrobotcontroller.organs.Instruments;
import com.qualcomm.ftcrobotcontroller.statics.ControlParser;
import com.qualcomm.ftcrobotcontroller.statics.Controls;

import java.util.ArrayList;

/**
 * Created by max on 5/5/16.
 *
 * Play the robot like pacman! Left/right joy turns robot 90 degrees,
 * top/bottom forward/reverse
 */
public class GridDrive implements Controller {
    private DriveTrain drivetrain;
    private Instruments instruments;

    private int[] angles = {0, 90, 180, 270};
    private int index = 0;
    private boolean debounce = false; //prevent multiple increments (held down joy)


    private void increment(int dir) {
        if(index == 0 && (dir < 0)) index = angles.length - 1;
        else if(index == angles.length - 1 && dir > 0) index = 0;
        else index += dir;
    }

    public GridDrive(DriveTrain dt, Instruments i) {
        drivetrain = dt;
        instruments = i;
    }


    public boolean tick() {
        ArrayList<Float> joyValues = ControlParser.range(Controls.GridDrive);
        HumanDriving.Direction direction = HumanDriving.joyDirection(joyValues);

        int dir = ((direction == HumanDriving.Direction.FORWARD ||
        direction == HumanDriving.Direction.RIGHT) ? 1 : -1);

        if(direction == HumanDriving.Direction.FORWARD ||
                direction == HumanDriving.Direction.REVERSE) drivetrain.goForward(0.5f * dir);

        else if((direction == HumanDriving.Direction.LEFT ||
                direction == HumanDriving.Direction.RIGHT) && !debounce) {
            debounce = true;
            increment(dir);
            ArrayList<Float> powers = Cardinal.AngleToDirection(instruments.yaw,
                    angles[index]);
            drivetrain.drive(powers.get(0), powers.get(1));

        }

        else if(direction == HumanDriving.Direction.NONE) {
            debounce = false;
            ArrayList<Float> powers = Cardinal.AngleToDirection(instruments.yaw,
                    angles[index]);
            drivetrain.drive(powers.get(0), powers.get(1));
        }
        Logger.logLine("Yaw: " + instruments.yaw + " dest: " + angles[index] + "HELLo");
        return false;
    }
}
