package com.qualcomm.ftcrobotcontroller.organs;

import com.qualcomm.ftcrobotcontroller.debug.Test;
import com.qualcomm.ftcrobotcontroller.statics.Hardware;
import com.qualcomm.ftcrobotcontroller.tissues.TMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Admin on 4/18/2016.
 */
public class TwoWheelDrivetrain extends DriveTrain implements Test {
    private TMotor leftWheel, rightWheel;
    public TwoWheelDrivetrain() {
        leftWheel = new TMotor(Hardware.MotorLeftFront);
        rightWheel = new TMotor(Hardware.MotorRightFront);
    }

    public void drive(float left, float right) {
        left = Range.clip(left, -1.0f, 1.0f);
        left = Range.clip(left, -1.0f, 1.0f);

        leftWheel.move(left);
        rightWheel.move(right);
    }

    public String test() {
        return "";
    }
}
