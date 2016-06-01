package com.qualcomm.ftcrobotcontroller.controllers.autonomous;

import com.qualcomm.ftcrobotcontroller.controllers.Controller;
import com.qualcomm.ftcrobotcontroller.neurons.Distance;
import com.qualcomm.ftcrobotcontroller.organs.DriveTrain;
import com.qualcomm.ftcrobotcontroller.organs.Instruments;

/**
 * Created by robotics on 5/3/16.
 */
public class GoToWall implements Controller {
    private DriveTrain drivetrain;
    private Instruments instruments;

    public GoToWall(DriveTrain dt, Instruments i) {
        drivetrain = dt;
        instruments = i;
    }
    public boolean tick() {
        if(Distance.isAtWall(instruments.distance)) {
            drivetrain.stop();
        }
        else {
            drivetrain.goForward(0.5f);
        }
        return Distance.isAtWall(instruments.distance);
    }
}
