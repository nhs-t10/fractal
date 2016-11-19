package org.firstinspires.ftc.teamcode.opmodes.clyde;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.controllers.autonomous.KnockBall;
import org.firstinspires.ftc.teamcode.opmodes.T10Autonomous;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;

/**
 * Created by max on 11/10/16.
 * Drives forward for 3 seconds.
 */
@Autonomous(name="Knock Ball", group="Autonomous")
public class DumbAuto extends T10Autonomous {
    public void registration() {
        MecanumDrivetrain dt = new MecanumDrivetrain();
        registerController(new KnockBall(dt));
    }
}
