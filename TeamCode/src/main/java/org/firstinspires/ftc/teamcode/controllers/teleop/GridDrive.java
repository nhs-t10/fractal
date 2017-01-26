package org.firstinspires.ftc.teamcode.controllers.teleop;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
import org.firstinspires.ftc.teamcode.neurons.HumanDriving;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;
import org.firstinspires.ftc.teamcode.statics.ControlParser;
import org.firstinspires.ftc.teamcode.statics.Controls;

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
    private AngleTurning angleTurning;

    private int[] angles = {-180, -90, 0, 90};
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
        double yaw = instruments.yaw;

        int dir = ((direction == HumanDriving.Direction.FORWARD ||
        direction == HumanDriving.Direction.RIGHT) ? 1 : -1);

        if(direction == HumanDriving.Direction.FORWARD ||
                direction == HumanDriving.Direction.REVERSE) drivetrain.goForward(0.5f * dir);

        else if((direction == HumanDriving.Direction.LEFT ||
                direction == HumanDriving.Direction.RIGHT) && !debounce) {
            debounce = true;
            increment(dir);
            angleTurning = new AngleTurning(angles[index]);
            ArrayList<Float> powers = angleTurning.getPivotPowers(instruments.yaw);
            drivetrain.drive(powers.get(0), powers.get(1));
        }

        else if(direction == HumanDriving.Direction.NONE) {
            debounce = false;
            ArrayList<Float> powers = angleTurning.getPivotPowers(instruments.yaw);
            drivetrain.drive(powers.get(0), powers.get(1));
        }
        Logger.logLine("Yaw: " + yaw + " dest: " + angles[index] + "HELLo");
        return false;
    }
}
