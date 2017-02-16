package org.firstinspires.ftc.teamcode.tissues;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.lib.Sleep;
import org.firstinspires.ftc.teamcode.statics.Hardware;

/**
 * Created by max on 4/17/16.
 */
public class TCRServo implements Component {
    private CRServo servo;
    public String getName(){return "Servo";}
    public TCRServo(String s) {
        servo = Hardware.getHardwareMap().crservo.get(s);
    }

    /**
     * Sets the direction of the servo
     * @param dir true = forward; false = backward
     */
    public void setDirection(boolean dir) {
        servo.setDirection((dir ? CRServo.Direction.FORWARD : CRServo.Direction.REVERSE));
    }

    /**
     * Sets the TCRServo to a given power.
     * @param power value between -1.0 and 1.0. Negative values move motor in reverse
     *              direction.
     */
    public void move(double power) {
        servo.setPower(power);
    }

    public void stop() {
        servo.setPower(0);
    }

    public boolean test() {
        this.move(1f);
        Sleep.secs(1);
        this.stop();
        return true;
    }
}

//TODO: better multi direction