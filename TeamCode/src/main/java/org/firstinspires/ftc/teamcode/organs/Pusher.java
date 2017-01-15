package org.firstinspires.ftc.teamcode.organs;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.lib.Sleep;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TServo;

/**
 * Created by nhs on 10/21/16.
 */

public class Pusher implements Component {
    private double inPos;
    private double outPos;

    private TServo servo;
    public Pusher() {
       this(0.15, 1);
    }

    public Pusher(double left, double right) {
        inPos = left;
        outPos = right;

        servo = new TServo(Hardware.ServoPusher);
        moveIn();
    }

    public void moveIn() {
        servo.moveTo(inPos);
    }
    public void moveOut() {
        servo.moveTo(outPos);
    }
    public void pushButton() {
        moveOut();
        moveIn();
    }
    public void moveTo(double pos) {
        Logger.logLine("Max: " + Servo.MAX_POSITION + " Min: " + Servo.MIN_POSITION);
        servo.moveTo(pos);
    }

    public String getName() { return "Button Pusher"; }

    public boolean test() {
        pushButton();
        return true;
    }
}
