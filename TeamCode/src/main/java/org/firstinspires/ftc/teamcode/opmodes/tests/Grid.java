package org.firstinspires.ftc.teamcode.opmodes.tests;

import org.firstinspires.ftc.teamcode.controllers.teleop.GridDrive;
import org.firstinspires.ftc.teamcode.opmodes.T10Opmode;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.drivetrains.TreadDrivetrain;

/**
 * Created by Admin on 4/19/2016.
 */
public class Grid extends T10Opmode {
    private GridDrive gd;
    private Instruments instruments;

    public void run()  {
        TreadDrivetrain tdt = new TreadDrivetrain();
        Instruments instruments = new Instruments();
        instruments.start();
        gd = new GridDrive(tdt, instruments);
    }

    public void tick() {
        gd.tick();
    }
}