package org.firstinspires.ftc.teamcode.opmodes.fakechassis;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.teleop.OneStickDrive;
import org.firstinspires.ftc.teamcode.controllers.teleop.OneStickMecanum;
import org.firstinspires.ftc.teamcode.controllers.teleop.Tray;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.opmodes.T10Opmode;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;

import java.util.ArrayList;

/**
 * Created by shaash on 4/25/17.
 */
@TeleOp(name="BonnieOp", group="Bonnie")
public class BasicTeleop extends T10Opmode{
    private OneStickDrive drivetrain;
    private ArrayList<Controller> controllers = new ArrayList<Controller>();
    public void run() {
        Logger.logLine("Chassis 1 initialized.");
        drivetrain = new OneStickDrive(drivetrain);


        //        flicker = new Flicker(false, 1);
//        spinner = new Spinner(1);
//        pusher = new Pusher();

        controllers.add(new OneStickMecanum(drivetrain));
        controllers.add(new Tray());
//        controllers.add(new Collection(flicker, spinner));
//        controllers.add(new ButtonPusher(pusher));
    }
    public void tick() {
        for(int i=0; i<controllers.size(); i++) {
            controllers.get(i).tick();
        }
    }
}
