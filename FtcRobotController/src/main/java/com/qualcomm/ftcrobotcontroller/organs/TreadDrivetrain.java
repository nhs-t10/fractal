package com.qualcomm.ftcrobotcontroller.organs;

import com.qualcomm.ftcrobotcontroller.debug.Test;
import com.qualcomm.robotcore.util.Range;

import com.qualcomm.ftcrobotcontroller.statics.Hardware;
import com.qualcomm.ftcrobotcontroller.tissues.TMotor;
import com.qualcomm.ftcrobotcontroller.utils.Sleep;
/**
 * Created by max on 4/17/16.
 */
public class TreadDrivetrain extends DriveTrain implements Test {
    private TMotor leftRear, leftFront, rightRear, rightFront;
    public TreadDrivetrain() {
        leftRear = new TMotor(Hardware.MotorLeftRear);
        leftFront = new TMotor(Hardware.MotorLeftFront);
        rightRear = new TMotor(Hardware.MotorRightRear);
        rightFront.setDirection(false);
        rightFront = new TMotor(Hardware.MotorRightFront);
        rightRear.setDirection(false);
    }

    public void drive(float left, float right) {
        right = (float)Range.clip(right, -1.0, 1.0);
        left = (float)Range.clip(left, -1.0, 1.0);

        leftRear.move(left);
        leftFront.move(left);
        rightRear.move(right);
        rightFront.move(right);
    }

    /**
     * This method is deprecated. Please use turn().
     */
    @Deprecated
    public void turnLeft(float pwr) {
        drive(pwr, -pwr);
    }
    /**
     * This method is deprecated. Please use turn().
     */
    @Deprecated
    public void turnRight(float pwr) {
        drive(-pwr, pwr);
    }

    public String test() {
        goForward(0.5f);
        Sleep.secs(2);
        stop();
        turn(-0.5f);
        Sleep.secs(2);
        stop();
        return "Driving test complete.";
    }
}
