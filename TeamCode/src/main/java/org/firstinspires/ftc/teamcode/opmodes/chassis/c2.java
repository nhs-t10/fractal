package org.firstinspires.ftc.teamcode.opmodes.chassis;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.teleop.Collection;
import org.firstinspires.ftc.teamcode.controllers.teleop.OneStickMecanum;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.opmodes.T10Opmode;
import org.firstinspires.ftc.teamcode.organs.Flicker;
import org.firstinspires.ftc.teamcode.organs.Spinner;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;

import java.util.ArrayList;

/**
 * Created by max on 10/19/16.
 */
@TeleOp(name="Chassis 1", group="Chassis")
public class c2 extends T10Opmode {
    private MecanumDrivetrain drivetrain;

    private ArrayList<Controller> controllers = new ArrayList<Controller>();
    public void run() {
        Logger.logLine("Chassis 1 initialized.");
        drivetrain = new MecanumDrivetrain();

        controllers.add(new OneStickMecanum(drivetrain));
    }
    public void tick() {
        for(int i=0; i<controllers.size(); i++) {
            controllers.get(i).tick();
        }
    }
}
