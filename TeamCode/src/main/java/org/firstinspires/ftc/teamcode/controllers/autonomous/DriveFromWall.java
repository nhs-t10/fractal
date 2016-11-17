package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;

/**
 * Created by nhs on 11/17/16.
 */
public class DriveFromWall implements Controller {
    MecanumDrivetrain driveTrain;
    Instruments instruments;
    double limit = 0;
    public DriveFromWall(Instruments i, MecanumDrivetrain dt, double l) {
        instruments = i;
        driveTrain = dt;
        limit = l;
    }
    public boolean tick() {
        Logger.logLine("d:" + instruments.distance);
        if (instruments.distance >= limit) {
            driveTrain.stop();
            return true;
        }
        driveTrain.driveSideways(0.5f);
        return false;
    }
}
