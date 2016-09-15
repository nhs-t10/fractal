package org.firstinspires.ftc.teamcode.opmodes.tests;

import org.firstinspires.ftc.teamcode.controllers.teleop.OneStickDrive;
import org.firstinspires.ftc.teamcode.opmodes.T10Opmode;
import org.firstinspires.ftc.teamcode.organs.QuadDrivetrain;
import org.firstinspires.ftc.teamcode.organs.TreadDrivetrain;

/**
 * Created by Admin on 4/19/2016.
 */
public class StickDrive extends T10Opmode {
    private OneStickDrive osd;

    public void run()  {
        TreadDrivetrain tdt = new TreadDrivetrain();
        osd = new OneStickDrive(tdt);
    }

    public void tick() {
        osd.tick();
    }
}