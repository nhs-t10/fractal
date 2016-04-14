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
    public void move(double power) {
        motor.setPower(power);
    }
    public void stop() {
        motor.setPower(0);
    }
    public String test() {
        this.move(0.5f);
        try {
            Thread.sleep(1000);
        }
        catch(Exception err) {
            err.printStackTrace();
            return "oh my";
        }
        this.stop();
        return "yee";
    }
}

//new Test(true, "motor was completed")
// [✓] "motor was done"
