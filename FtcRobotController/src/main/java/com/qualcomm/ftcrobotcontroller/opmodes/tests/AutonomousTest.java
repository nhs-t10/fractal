package com.qualcomm.ftcrobotcontroller.opmodes.tests;

import com.qualcomm.ftcrobotcontroller.controllers.autonomous.GoToWall;
import com.qualcomm.ftcrobotcontroller.opmodes.T10Autonomous;
import com.qualcomm.ftcrobotcontroller.organs.Instruments;
import com.qualcomm.ftcrobotcontroller.organs.QuadDrivetrain;
import com.qualcomm.ftcrobotcontroller.organs.TreadDrivetrain;

/**
 * Created by Admin on 4/19/2016.
 */
public class AutonomousTest extends T10Autonomous {
    public void registration()  {
        TreadDrivetrain tdt = new TreadDrivetrain();
        Instruments instruments = new Instruments();
        instruments.start();
        GoToWall gtw = new GoToWall(tdt, instruments);
        registerController(gtw);
    }
}