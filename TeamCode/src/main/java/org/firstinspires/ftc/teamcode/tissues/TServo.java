package org.firstinspires.ftc.teamcode.tissues;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.statics.Hardware;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by max on 4/17/16.
 */
public class TServo implements Component {
    private Servo servo;
    public String getName(){return "Servo";}
    public TServo(String s) {
        servo = Hardware.getHardwareMap().servo.get(s);
    }

    /**
     * Sets the direction of the servo
     * @param dir true = forward; false = backward
     */
    public void setDirection(boolean dir) {
        servo.setDirection((dir ? Servo.Direction.FORWARD : Servo.Direction.REVERSE));
    }

    /**
     * Moves the TServo to a given position.
     * @param pos double between 0.0 and 1.0
     */
    public void moveTo(double pos) {
        pos = (float) Range.clip(pos, 0, 1.0);
        servo.setPosition(pos);
    }

    public boolean test() {
        this.moveTo(0.1);
        this.moveTo(0.5);
        return true;
    }
}

//TODO: better multi direction