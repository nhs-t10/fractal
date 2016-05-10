package com.qualcomm.ftcrobotcontroller.tissues;

import com.qualcomm.ftcrobotcontroller.debug.Component;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by max on 4/17/16.
 */
public class TServo extends Component {
    private Servo servo;
    public String name = "Servo";
    public TServo(Servo s) {
        servo = s;
    }
    public void setDirection(Boolean forward) {
        servo.setDirection((forward ? Servo.Direction.FORWARD : Servo.Direction.REVERSE));
    }
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