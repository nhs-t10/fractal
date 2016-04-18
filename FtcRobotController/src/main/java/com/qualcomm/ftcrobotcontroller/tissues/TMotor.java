package com.qualcomm.ftcrobotcontroller.tissues;
import com.qualcomm.ftcrobotcontroller.debug.Component;
import com.qualcomm.ftcrobotcontroller.utils.Sleep;
import com.qualcomm.robotcore.hardware.DcMotor;
/**
 * Created by robotics on 4/12/16.
 */
public class TMotor implements Component {
    private DcMotor motor;
    public TMotor(DcMotor m) {
        motor = m;
    }
    public void setDirection(Boolean forward) {
        motor.setDirection((forward ? DcMotor.Direction.FORWARD : DcMotor.Direction.REVERSE));
    }
    public void move(double power) {
        motor.setPower(power);
    }
    public void stop() {
        motor.setPower(0);
    }
    public String test() {
        this.move(0.5f);
        Sleep.secs(2);
        this.stop();
        return "Motor: " + motor.getConnectionInfo();
    }
}

//TODO: Encoder support
