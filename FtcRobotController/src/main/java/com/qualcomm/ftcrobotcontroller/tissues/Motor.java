package com.qualcomm.ftcrobotcontroller.tissues;
import com.qualcomm.robotcore.hardware.DcMotor;
/**
 * Created by robotics on 4/12/16.
 */
public class Motor {
    private DcMotor motor;
    public Motor(DcMotor m) {
        motor = m;
    }
    public String test() {
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

//new Test(true, "motor was completed")
// [✓] "motor was done"
