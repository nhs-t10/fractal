package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.controllers.tests.ChangeableVariable;
import org.firstinspires.ftc.teamcode.opmodes.T10Opmode;
import org.firstinspires.ftc.teamcode.organs.Pusher;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;

/**
 * Created by robotics on 11/18/16.
 */
@TeleOp(name="Changeable Tester")
public class ChangeTest extends T10Opmode {
    ChangeableVariable var;
    Pusher pusher;
    @Override
    public void run() {
        pusher = new Pusher();
        var = new ChangeableVariable("ServPos", 0.5, 0.05);
    }

    @Override
    public void tick() {
        var.tick();
        pusher.moveTo(var.getVariable(), "Right");
    }
}
