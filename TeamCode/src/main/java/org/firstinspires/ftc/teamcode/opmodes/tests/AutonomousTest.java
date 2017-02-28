package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.controllers.autonomous.DriveToLine;
import org.firstinspires.ftc.teamcode.controllers.autonomous.PrepForAuto;
import org.firstinspires.ftc.teamcode.controllers.autonomous.TurnX;
import org.firstinspires.ftc.teamcode.controllers.tests.Stall;
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
    private int stallTime = 2000;
    public void registration()  {
        final MecanumDrivetrain md = new MecanumDrivetrain();
        Pusher p = new Pusher();
        Instruments instruments = new Instruments();
        instruments.start();
        cam = new TCamera();
//        registerController(new AverageTime());
//        registerController(new TurnX(instruments, md, 90));
//        final View relativeLayout = ((Activity) hardwareMap.appContext).findViewById(R.id.RelativeLayout);
//        relativeLayout.post(new Runnable() {
//            public void run() {
//                relativeLayout.setBackgroundColor(Color.GREEN);
//            }
//        });
////        registerController(new DriftToLine(instruments, md, -0.1f, true));
////        registerController(new PressBeacon(true, Team.RED, instruments, md, p, cam));
        registerController(new TurnX(instruments, md, 0));
        registerController(new Stall(stallTime, 0, instruments));
        registerController(new TurnX(instruments, md, 90));
        registerController(new Stall(stallTime, 90, instruments));
        registerController(new TurnX(instruments, md, -60));
        registerController(new Stall(stallTime, -60, instruments));
        registerController(new TurnX(instruments, md, -65));
        registerController(new Stall(stallTime, -65, instruments));
        registerController(new TurnX(instruments, md, -170));
        registerController(new Stall(stallTime, -170, instruments));
        registerController(new TurnX(instruments, md, 189));
        registerController(new Stall(stallTime, 189, instruments));
//        registerController(new PrepForAuto());
//        registerController(new TurnX(instruments, md, 65));
//        registerController(new Stall(1000));
//        registerController(new DriveToLine(instruments, md, 65));
    }
    @Override
    public void stop() {
        cam.stop();
    }
}