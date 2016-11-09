package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.controllers.autonomous.GoToWall;
import org.firstinspires.ftc.teamcode.controllers.autonomous.KnockBall;
import org.firstinspires.ftc.teamcode.opmodes.T10Autonomous;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.organs.drivetrains.TreadDrivetrain;

/**
 * Created by Admin on 4/19/2016.
 */
@Autonomous(name="Drive To Wall", group="Autonomous Tests")
public class AutonomousTest extends T10Autonomous {
    public void registration()  {
        MecanumDrivetrain m = new MecanumDrivetrain();
        registerController(new KnockBall(m));
    }
}