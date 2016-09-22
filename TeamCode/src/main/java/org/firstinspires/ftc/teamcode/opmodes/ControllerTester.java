package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.teleop.AccStickDrive;
import org.firstinspires.ftc.teamcode.controllers.teleop.GimbalBumpers;
import org.firstinspires.ftc.teamcode.controllers.tests.ButtonTest;
import org.firstinspires.ftc.teamcode.organs.Gimbal;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.drivetrains.TreadDrivetrain;

import java.util.ArrayList;

/**
 * Created by Admin on 4/19/2016.
 *
 * Tests tick-based controllers.
 */
@TeleOp(name="Controller Tester", group="Testers")
public class ControllerTester extends T10Opmode {
    private ArrayList<Controller> tests = new ArrayList<Controller>();

    public void run()  {
        //add organs here
        TreadDrivetrain tdt = new TreadDrivetrain();
        Instruments instruments = new Instruments();
        instruments.start();
        Gimbal gimbal = new Gimbal();

        //add controllers here
        tests.add(new AccStickDrive(tdt));
        tests.add(new GimbalBumpers(gimbal));
        tests.add(new ButtonTest("^A1"));
    }

    public void tick() {
        for(int i=0; i<tests.size(); i++) {
            tests.get(i).tick();
        }
    }
}