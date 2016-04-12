package com.qualcomm.ftcrobotcontroller.tissues;
import com.qualcomm.robotcore.hardware.DcMotor;
/**
 * Created by robotics on 4/12/16.
 */
public class Motor {
    public String test(DcMotor motor) {
        motor.setPower(0.5f);
        try {
            Thread.sleep(1000);
        }
        catch(Exception err) {
            err.printStackTrace();
            return "oh my";
        }
        motor.setPower(0);
        return "yee";
    }
}
