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

//true is right, false is left
public class Pusher implements Component {
    private double inPos;
    private double outPos;
    private boolean isExtendedR = false;
    private boolean isExtendedL = false;

    private TServo servoR;
    private TServo servoL;
    public Pusher() {
       this(0.275, 1);
    }

    public Pusher(double in, double out) {
        inPos = in;
        outPos = out;

        servoR = new TServo(Hardware.ServoPusherRight);
        moveIn(true);
        servoL = new TServo(Hardware.ServoPusherLeft);
        moveIn(false);
    }

    public void moveIn(boolean side) {
        if (side){
            servoR.moveTo(inPos);
        }
        else servoL.moveTo(inPos);
    }
    public void moveOut(boolean side) {
        if (side){
            servoR.moveTo(outPos);
        }
        else servoL.moveTo(outPos);
    }
    public void toggle(boolean side) {
        if (side){
            Logger.logLine("Right Toggle");
            if (isExtendedR) moveIn(true);
            else moveOut(true);
            isExtendedR = !isExtendedR;
        }
        else {
            Logger.logLine("Left Toggle");
            if (isExtendedL) moveIn(false);
            else moveOut(false);
            isExtendedL = !isExtendedL;
        }
    }
    public void pushButton(boolean side) { // NOTE: it may be that for autonomous it's better to wait till the color changes
        moveIn(side);
        moveOut(side);
        Sleep.secs(2.5);
        moveIn(side);
    }
    public void moveTo(double pos, String side) {
        Logger.logLine("Max: " + Servo.MAX_POSITION + " Min: " + Servo.MIN_POSITION);
        if (side.equals("Right")){
            Logger.logLine("Right Push");
            servoR.moveTo(pos);
        }
        else {
            Logger.logLine("Left Push");
            servoL.moveTo(pos);
        }

    }

    public String getName() { return "Button Pusher"; }

    public boolean test() {
        pushButton(true);
        pushButton(false);
        return true;
    }
}
