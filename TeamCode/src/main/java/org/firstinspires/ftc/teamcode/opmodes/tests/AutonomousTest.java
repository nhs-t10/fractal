package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.Team;
import org.firstinspires.ftc.teamcode.controllers.autonomous.AverageTime;
import org.firstinspires.ftc.teamcode.controllers.autonomous.DriftToLine;
import org.firstinspires.ftc.teamcode.opmodes.T10Linear;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.Pusher;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;
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
        registerController(new AverageTime());
//        registerController(new DriftToLine(instruments, md, -0.1f, true));
//        registerController(new PressBeacon(true, Team.RED, instruments, md, p, cam));
//        registerController(new TurnX(instruments, md, 0));
//        registerController(new Stall(1000));
//        registerController(new TurnX(instruments, md, 90));
//        registerController(new Stall(1000));
//        registerController(new TurnX(instruments, md, -60));
//        registerController(new Stall(1000));
//        registerController(new TurnX(instruments, md, -65));
//        registerController(new Stall(1000));
//        registerController(new TurnX(instruments, md, -170));
//        registerController(new Stall(1000));
//        registerController(new TurnX(instruments, md, 189));
//        registerController(new Stall(1000));

    }
    @Override
    public void stop() {
        cam.stop();
    }
}