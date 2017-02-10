package org.firstinspires.ftc.teamcode.opmodes.tests;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.Team;
import org.firstinspires.ftc.teamcode.controllers.autonomous.AverageTime;
import org.firstinspires.ftc.teamcode.controllers.autonomous.DriftToLine;
import org.firstinspires.ftc.teamcode.controllers.autonomous.TurnX;
import org.firstinspires.ftc.teamcode.controllers.tests.Stall;
import org.firstinspires.ftc.teamcode.opmodes.T10Linear;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.Pusher;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.tissues.TCamera;
import android.app.Activity;
import android.graphics.Color;
import android.view.View;

import com.qualcomm.ftccommon.DbgLog;
import com.qualcomm.ftcrobotcontroller.R;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.DigitalChannelController;

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
//        registerController(new PressBeacon(true, Team.RED, instruments, md, p, cam));
        registerController(new TurnX(instruments, md, 0));
        registerController(new Stall(stallTime));
        registerController(new TurnX(instruments, md, 90));
        registerController(new Stall(stallTime));
        registerController(new TurnX(instruments, md, -60));
        registerController(new Stall(stallTime));
        registerController(new TurnX(instruments, md, -65));
        registerController(new Stall(stallTime));
        registerController(new TurnX(instruments, md, -170));
        registerController(new Stall(stallTime));
        registerController(new TurnX(instruments, md, 189));
        registerController(new Stall(stallTime));

    }
    @Override
    public void stop() {
        cam.stop();
    }
}