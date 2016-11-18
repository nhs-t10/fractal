package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.lib.Sleep;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;

/**
 * Created by nhs on 11/8/16.
 */

public class TimeFromWall implements Controller {
    private MecanumDrivetrain driveTrain;
    private int time;
    public TimeFromWall(MecanumDrivetrain d, int t) {
        driveTrain = d;
        time = t;
    }
    public boolean tick() {
        driveTrain.driveSideways(0.5f);
        Sleep.ms(time);
        driveTrain.stop();
        return true;
    }
}
