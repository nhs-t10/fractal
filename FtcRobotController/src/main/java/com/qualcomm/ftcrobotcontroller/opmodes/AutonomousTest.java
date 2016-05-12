package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.controllers.autonomous.GoToWall;
import com.qualcomm.ftcrobotcontroller.organs.Instruments;
import com.qualcomm.ftcrobotcontroller.organs.QuadDrivetrain;
import com.qualcomm.ftcrobotcontroller.organs.TreadDrivetrain;

/**
 * Created by Admin on 4/19/2016.
 */
public class AutonomousTest extends T10Autonomous {
    public void registration()  {
        QuadDrivetrain tdt = new QuadDrivetrain();
        Instruments instruments = new Instruments();
        instruments.start();
        GoToWall gtw = new GoToWall(tdt, instruments);
        registerController(gtw);
    }
}