package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.controllers.TeleSensors;
import com.qualcomm.ftcrobotcontroller.controllers.teleop.OneStickDrive;
import com.qualcomm.ftcrobotcontroller.organs.QuadDrivetrain;
import com.qualcomm.ftcrobotcontroller.organs.TreadDrivetrain;

/**
 * Created by Admin on 4/19/2016.
 */
public class StickDrive extends T10Opmode {
    private OneStickDrive osd;
    private TeleSensors ts;

    public void run()  {
        QuadDrivetrain tdt = new QuadDrivetrain();
        osd = new OneStickDrive(tdt);
        ts = new TeleSensors();
    }

    public void tick() {
        osd.tick();
        ts.tick();
    }
}