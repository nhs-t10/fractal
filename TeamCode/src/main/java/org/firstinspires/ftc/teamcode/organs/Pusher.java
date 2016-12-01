package org.firstinspires.ftc.teamcode.organs;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.lib.Sleep;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TServo;

/**
 * Created by nhs on 10/21/16.
 */

public class Pusher implements Component {
    private float leftPos;
    private float rightPos;

    private TServo servo;
    public Pusher() {
       this(0.0f, 1.3f);
    }

    public Pusher(float left, float right) {
        leftPos = left;
        rightPos = right;

        servo = new TServo(Hardware.ServoPusher);
        servo.moveTo(0.5);
    }

    public void pushLeft() {
        servo.moveTo(leftPos);
    }
    public void pushRight() {
        servo.moveTo(rightPos);
    }

    public String getName() { return "Button Pusher"; }

    public boolean test() {
        pushLeft();
        Sleep.secs(1);
        pushRight();
        return true;
    }
}
