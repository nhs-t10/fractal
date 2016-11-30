package org.firstinspires.ftc.teamcode.organs;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.lib.Sleep;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TServo;

/**
 * Created by nhs on 10/21/16.
 */

public class Pusher implements Component {
    public String getName() { return "Button Pusher"; }
    private TServo servo;
    public Pusher() {
        servo = new TServo(Hardware.ServoPusher);
        servo.moveTo(0.5);
    }
    public void pushLeft() {
        servo.moveTo(0);
    }
    public void pushRight() {
        servo.moveTo(1.3);
    }
    public boolean test() {
        pushLeft();
        Sleep.secs(1);
        pushRight();
        return true;
    }
}
