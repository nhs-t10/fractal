package org.firstinspires.ftc.teamcode.opmodes.clyde;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.teleop.ButtonPusher;
import org.firstinspires.ftc.teamcode.controllers.teleop.BonnieCollection;
import org.firstinspires.ftc.teamcode.controllers.teleop.Collection;
import org.firstinspires.ftc.teamcode.controllers.teleop.OneStickMecanum;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.opmodes.T10Opmode;
import org.firstinspires.ftc.teamcode.organs.Flicker;
import org.firstinspires.ftc.teamcode.organs.Pusher;
import org.firstinspires.ftc.teamcode.organs.Spinner;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;

import java.util.ArrayList;

/**
 * Created by max on 10/19/16.
 */
@TeleOp(name="ClydeOp", group="Clyde")
public class clyde extends T10Opmode {
    private MecanumDrivetrain drivetrain;
    private Flicker flicker;
    private Spinner spinner;
    private Pusher pusher;

    private ArrayList<Controller> controllers = new ArrayList<Controller>();
    public void run() {
        Logger.logLine("Chassis 1 initialized.");
        drivetrain = new MecanumDrivetrain();
        flicker = new Flicker();
        spinner = new Spinner();
        pusher = new Pusher();

        controllers.add(new OneStickMecanum(drivetrain));
        controllers.add(new Collection(flicker, spinner));
        controllers.add(new ButtonPusher(pusher));
    }
    public void tick() {
        for(int i=0; i<controllers.size(); i++) {
            controllers.get(i).tick();
        }
    }
}
