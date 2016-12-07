package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.controllers.tests.ChangeableVariable;
import org.firstinspires.ftc.teamcode.opmodes.T10Opmode;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;

/**
 * Created by robotics on 11/18/16.
 */
@TeleOp(name="Changeable Tester")
public class ChangeTest extends T10Opmode {
    ChangeableVariable var;
    MecanumDrivetrain md;
    @Override
    public void run() {
        md = new MecanumDrivetrain();
        var = new ChangeableVariable("Speed", 0, 0.05);
    }

    @Override
    public void tick() {
        var.tick();
        md.goForward((float) var.getVariable());
    }
}
