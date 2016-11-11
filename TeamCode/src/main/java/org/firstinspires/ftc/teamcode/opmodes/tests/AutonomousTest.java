package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.controllers.autonomous.GoToWall;
import org.firstinspires.ftc.teamcode.controllers.autonomous.KnockBall;
import org.firstinspires.ftc.teamcode.controllers.autonomous.Turn90;
import org.firstinspires.ftc.teamcode.opmodes.T10Autonomous;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.organs.drivetrains.TreadDrivetrain;

/**
 * Created by Admin on 4/19/2016.
 */
@Autonomous(name="Autonomous Test", group="Autonomous Tests")
public class AutonomousTest extends T10Autonomous {
    public void registration()  {
        MecanumDrivetrain driveTrain = new MecanumDrivetrain();
        Instruments instruments = new Instruments();
        instruments.start();
        registerController(new Turn90(instruments, driveTrain));
    }
}