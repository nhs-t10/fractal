package com.qualcomm.ftcrobotcontroller.opmodes.tests;

import com.qualcomm.ftcrobotcontroller.controllers.teleop.OneStickDrive;
import com.qualcomm.ftcrobotcontroller.opmodes.T10Opmode;
import com.qualcomm.ftcrobotcontroller.organs.QuadDrivetrain;

/**
 * Created by Admin on 4/19/2016.
 */
public class StickDrive extends T10Opmode {
    private OneStickDrive osd;

    public void run()  {
        QuadDrivetrain tdt = new QuadDrivetrain();
        osd = new OneStickDrive(tdt);
    }

    public void tick() {
        osd.tick();
    }
}