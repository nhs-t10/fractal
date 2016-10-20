package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.teleop.AccStickDrive;
import org.firstinspires.ftc.teamcode.controllers.teleop.Collection;
import org.firstinspires.ftc.teamcode.controllers.teleop.GimbalBumpers;
import org.firstinspires.ftc.teamcode.controllers.teleop.OneStickDrive;
import org.firstinspires.ftc.teamcode.controllers.teleop.OneStickMecanum;
import org.firstinspires.ftc.teamcode.controllers.tests.ButtonTest;
import org.firstinspires.ftc.teamcode.organs.Flicker;
import org.firstinspires.ftc.teamcode.organs.Gimbal;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.Spinner;
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
        //this shit threw 1000000 errors. Not dealing with.
        //Instruments instruments = new Instruments();
        //instruments.start();
//        Spinner spinner = new Spinner();
//        Flicker flicker = new Flicker();

        //add controllers here
        //very very buggy :(
        //tests.add(new AccStickDrive(tdt));
        tests.add(new OneStickMecanum());
        tests.add(new ButtonTest("^A1"));
//        tests.add(new Collection(flicker, spinner));
    }

    public void tick() {
        for(int i=0; i<tests.size(); i++) {
            tests.get(i).tick();
        }
    }
}