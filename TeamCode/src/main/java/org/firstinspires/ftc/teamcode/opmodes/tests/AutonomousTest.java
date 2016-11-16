package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.controllers.Team;
import org.firstinspires.ftc.teamcode.controllers.autonomous.DriveToLine;
import org.firstinspires.ftc.teamcode.controllers.autonomous.PressBeacon;
import org.firstinspires.ftc.teamcode.opmodes.T10Autonomous;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.Pusher;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.organs.drivetrains.TreadDrivetrain;
import org.firstinspires.ftc.teamcode.tissues.TCamera;

/**
 * Created by Admin on 4/19/2016.
 */ll

@Autonomous(name="Autonomous Test", group="Autonomous Tests")
public class AutonomousTest extends T10Autonomous {
    private TCamera cam;
    public void registration()  {
        MecanumDrivetrain md = new MecanumDrivetrain();
//        Pusher p = new Pusher();
        Instruments instruments = new Instruments();
        instruments.start();
//        cam = new TCamera();
        DriveToLine dtl = new DriveToLine(instruments, md, Team.RED);
        registerController(dtl);
    }
    @Override
    public void stop() {
//        cam.stop();
    }
}