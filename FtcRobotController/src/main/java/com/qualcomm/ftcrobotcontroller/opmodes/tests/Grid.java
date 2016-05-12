package com.qualcomm.ftcrobotcontroller.opmodes.tests;

import com.qualcomm.ftcrobotcontroller.controllers.teleop.GridDrive;
import com.qualcomm.ftcrobotcontroller.controllers.teleop.OneStickDrive;
import com.qualcomm.ftcrobotcontroller.opmodes.T10Opmode;
import com.qualcomm.ftcrobotcontroller.organs.Instruments;
import com.qualcomm.ftcrobotcontroller.organs.QuadDrivetrain;

/**
 * Created by Admin on 4/19/2016.
 */
public class Grid extends T10Opmode {
    private GridDrive gd;
    private Instruments instruments;

    public void run()  {
        QuadDrivetrain tdt = new QuadDrivetrain();
        Instruments instruments = new Instruments();
        instruments.start();
        gd = new GridDrive(tdt, instruments);
    }

    public void tick() {
        gd.tick();
    }
}