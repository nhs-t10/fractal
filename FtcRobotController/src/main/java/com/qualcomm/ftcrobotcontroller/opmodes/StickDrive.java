package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.controllers.OneStickDrive;
import com.qualcomm.ftcrobotcontroller.debug.Logger;
import com.qualcomm.ftcrobotcontroller.organs.TreadDrivetrain;
import com.qualcomm.ftcrobotcontroller.statics.Hardware;
import com.qualcomm.ftcrobotcontroller.tissues.TIMU;
import com.qualcomm.ftcrobotcontroller.tissues.TMotor;
import com.qualcomm.ftcrobotcontroller.tissues.TServo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Admin on 4/19/2016.
 */
public class StickDrive extends T10Opmode {
    public void run()  {
        TreadDrivetrain tdt = new TreadDrivetrain();
        OneStickDrive.init(tdt);
    }

    public void tick() {
        OneStickDrive.tick();
    }
}