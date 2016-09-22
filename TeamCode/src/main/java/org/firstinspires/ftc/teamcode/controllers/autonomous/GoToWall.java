package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.neurons.Distance;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;
import org.firstinspires.ftc.teamcode.organs.Instruments;

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
