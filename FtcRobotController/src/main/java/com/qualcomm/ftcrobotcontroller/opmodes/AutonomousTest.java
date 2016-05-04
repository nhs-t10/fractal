package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.controllers.teleop.OneStickDrive;
import com.qualcomm.ftcrobotcontroller.organs.TreadDrivetrain;

/**
 * Created by Admin on 4/19/2016.
 */
public class AutonomousTest extends T10Autonomous {
    public void registration()  {
        TreadDrivetrain tdt = new TreadDrivetrain();
        OneStickDrive osd = new OneStickDrive(tdt);
        registerController(osd);
    }
}