package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.controllers.Team;
import org.firstinspires.ftc.teamcode.controllers.autonomous.DriveToLine;
import org.firstinspires.ftc.teamcode.controllers.autonomous.PressBeacon;
import org.firstinspires.ftc.teamcode.controllers.autonomous.TurnX;
import org.firstinspires.ftc.teamcode.controllers.autonomous.TurnXDegrees;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.opmodes.T10Autonomous;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.Pusher;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.organs.drivetrains.TreadDrivetrain;
import org.firstinspires.ftc.teamcode.tissues.TCamera;

/**
 * Created by Admin on 4/19/2016.
 */

@Autonomous(name="Autonomous Test", group="Autonomous Tests")
public class AutonomousTest extends T10Autonomous {
    private TCamera cam;
    public void registration()  {
        MecanumDrivetrain md = new MecanumDrivetrain();
        Pusher p = new Pusher();
        Instruments instruments = new Instruments();
        instruments.start();
        cam = new TCamera();
        registerController(new PressBeacon(Team.RED, md, p, cam));
//        registerController(new TurnX(instruments, md, 0));
//        Logger.logLine("done 1");
//        registerController(new TurnX(instruments, md, 90, 2));
//        Logger.logLine("done 2");
//        registerController(new TurnX(instruments, md, -60, 3));
//        Logger.logLine("done 3");
//        registerController(new TurnX(instruments, md, -65, 4));
//        Logger.logLine("done 4");
//        registerController(new TurnX(instruments, md, -170, 5));
//        Logger.logLine("done 5");
//        registerController(new TurnX(instruments, md, 189, 6));
//        Logger.logLine("done 6");

    }
    @Override
    public void stop() {
        cam.stop();
    }
}