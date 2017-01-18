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
        servoL = new TServo(Hardware.ServoPusherLeft);
        servoR.moveTo(inPos);
        servoL.moveTo(inPos);
    }

//    public void toggle(boolean side) {
//        if (side){
//            Logger.logLine("Right Toggle");
//            if (isExtendedR) moveIn(true);
//            else moveOut(true);
//            isExtendedR = !isExtendedR;
//        }
//        else {
//            Logger.logLine("Left Toggle");
//            if (isExtendedL) moveIn(false);
//            else moveOut(false);
//            isExtendedL = !isExtendedL;
//        }
//    }
    public void extendLeft() {
        isExtendedL = true;
        servoL.moveTo(outPos);
    }
    public void extendRight() {
        isExtendedR = true;
        servoR.moveTo(outPos);
    }
    public void retractLeft() {
        isExtendedR = false;
        servoL.moveTo(inPos);
    }
    public void retractRight() {
        isExtendedR = false;
        servoR.moveTo(inPos);
    }
    public void pushLeft() {
        extendLeft();
        Sleep.secs(2.5);
        retractLeft();
    }
    public void pushRight() {
        extendRight();
        Sleep.secs(2.5);
        retractRight();
    }
    public void pushBoth() {
        extendLeft();
        extendRight();
        Sleep.secs(2.5);
        retractLeft();
        retractRight();
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
        pushLeft();
        pushRight();
        return true;
    }
}
