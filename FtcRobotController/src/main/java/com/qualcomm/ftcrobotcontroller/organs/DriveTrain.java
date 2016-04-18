package com.qualcomm.ftcrobotcontroller.organs;

/**
 * Created by Admin on 4/17/2016.
 */
public abstract class DriveTrain {
    public abstract void drive(float left, float right);

    public void goForward(float pwr) {
        drive(pwr, pwr);
    }

    /**
     * Turns robot based on power value between -1.0 and 1.0. Negative turns left, positive right.
     * @param pwr power used for turn
     */
    public void turn(float pwr) {
        drive(-pwr, pwr);
    }

    public void stop() {
        drive(0.0f, 0.0f);
    }
}
