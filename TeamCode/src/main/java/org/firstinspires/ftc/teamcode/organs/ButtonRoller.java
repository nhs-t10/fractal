package org.firstinspires.ftc.teamcode.organs;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TCRServo;

/**
 * Created by Jacob on 2/15/2017.
 */

public class ButtonRoller implements Component {
    public String getName() { return "ButtonRoller"; }
    private TCRServo servo;

    public ButtonRoller(){
        servo = new TCRServo(Hardware.ButtonRoller);
    }
    public void unwind(){servo.move(1f);}
    public void wind(){servo.move(-1f);}
    public void stop(){servo.stop();}
    public boolean test(){
        unwind();
        wind();
        return true;
    }
}
