package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.lib.Sleep;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;

/**
 * Created by nhs on 11/8/16.
 */

public class KnockBall implements Controller {
    private DriveTrain driveTrain;
    public KnockBall(DriveTrain d) {
        driveTrain = d;
    }
    public boolean tick() {
        driveTrain.goForward(1f);
        Sleep.secs(3);
        driveTrain.stop();
        return true;
    }
}
