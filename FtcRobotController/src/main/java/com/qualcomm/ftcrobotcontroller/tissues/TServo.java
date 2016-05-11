package com.qualcomm.ftcrobotcontroller.tissues;

import com.qualcomm.ftcrobotcontroller.debug.Component;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by max on 4/17/16.
 */
public class TServo implements Component {
    private Servo servo;
    public String name = "Servo";
    public TServo(Servo s) {
        servo = s;
    }

    /**
     * Sets the direction of the servo
     * @param dir true = forward; false = backward
     */
    public void setDirection(Boolean dir) {
        servo.setDirection((dir ? Servo.Direction.FORWARD : Servo.Direction.REVERSE));
    }

    /**
     * Moves the TServo to a given position.
     * @param pos double between 0.0 and 1.0
     */
    public void moveTo(double pos) {
        servo.setPosition(pos);
    }

    public Boolean test() {
        this.moveTo(0.1);
        this.moveTo(0.5);
        return true;
    }
}

//TODO: better multi direction