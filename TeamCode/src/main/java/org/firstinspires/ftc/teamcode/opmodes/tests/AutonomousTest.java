package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.Team;
import org.firstinspires.ftc.teamcode.controllers.autonomous.DriveToLine;
import org.firstinspires.ftc.teamcode.controllers.autonomous.LineFollow;
import org.firstinspires.ftc.teamcode.controllers.autonomous.PressBeacon;
import org.firstinspires.ftc.teamcode.controllers.autonomous.TurnX;
import org.firstinspires.ftc.teamcode.controllers.autonomous.TurnXDegrees;
import org.firstinspires.ftc.teamcode.controllers.tests.ChangeableVariable;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.LineAlignment;
import org.firstinspires.ftc.teamcode.opmodes.T10Autonomous;
import org.firstinspires.ftc.teamcode.opmodes.T10Linear;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.Pusher;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.organs.drivetrains.TreadDrivetrain;
import org.firstinspires.ftc.teamcode.tissues.TCamera;

/**
 * Created by Admin on 4/19/2016.
 */

@TeleOp(name="Autonomous Test", group="Autonomous Tests")
public class AutonomousTest extends T10Linear {
    private TCamera cam;
    public void registration()  {
        final MecanumDrivetrain md = new MecanumDrivetrain();
        Pusher p = new Pusher();
        Instruments instruments = new Instruments();
        instruments.start();
        cam = new TCamera();
        registerController(new PressBeacon(Team.RED, instruments, md, p, cam));
//        registerController(new TurnX(instruments, md, 0));
//        Logger.logLine("done 1");
//        registerController(new TurnX(instruments, md, 90));
//        Logger.logLine("done 2");
//        registerController(new TurnX(instruments, md, -60));
//        Logger.logLine("done 3");
//        registerController(new TurnX(instruments, md, -65));
//        Logger.logLine("done 4");
//        registerController(new TurnX(instruments, md, -170));
//        Logger.logLine("done 5");
//        registerController(new TurnX(instruments, md, 189));
//        Logger.logLine("done 6");

    }
    @Override
    public void stop() {
        cam.stop();
    }
}