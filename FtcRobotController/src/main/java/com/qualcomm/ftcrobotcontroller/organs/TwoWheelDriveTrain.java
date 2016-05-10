package com.qualcomm.ftcrobotcontroller.organs;

import com.qualcomm.ftcrobotcontroller.debug.Component;
import com.qualcomm.ftcrobotcontroller.statics.Hardware;
import com.qualcomm.ftcrobotcontroller.tissues.TMotor;
import com.qualcomm.ftcrobotcontroller.utils.Sleep;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Admin on 4/18/2016.
 */
public class TwoWheelDriveTrain extends DriveTrain {
    private TMotor leftWheel, rightWheel;
    public TwoWheelDriveTrain() {
        leftWheel = new TMotor(Hardware.MotorLeftFront);
        rightWheel = new TMotor(Hardware.MotorRightFront);
    }

    public void drive(float left, float right) {
        left = Range.clip(left, -1.0f, 1.0f);
        left = Range.clip(left, -1.0f, 1.0f);

        leftWheel.move(left);
        rightWheel.move(right);
    }
}
