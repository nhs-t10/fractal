package org.firstinspires.ftc.teamcode.statics;

import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by robotics on 4/14/16.
 */
public class Hardware {
    public static String MotorLeftRear, MotorRightRear, MotorLeftFront, MotorRightFront, Spinner, Flicker, LiftSpinner, ClydeTray;

    public static String ServoStop, ServoPusherRight, ServoPusherLeft, Spacer, ButtonRoller, SecondButtonRoller;

    public static String IMU, Color, Ultra, Lightone, Lighttwo, Touch, ContactLeft, ContactRight, IRDistance, Unwinder;

    private static HardwareMap hardwareMap;

    public static HardwareMap getHardwareMap() { return hardwareMap; }

    public static void init(HardwareMap h) {
        hardwareMap = h;

        MotorLeftRear = "m1";
        MotorRightRear = "m2";
        MotorLeftFront = "m3";
        MotorRightFront = "m4";
        ServoPusherRight = "pusherR";
        ServoPusherLeft = "pusherL";
        Spacer = "spacer";
        ButtonRoller = "br";
        SecondButtonRoller = "br2";


        Spinner = "m5";
        Flicker = "m6";
        LiftSpinner = "m7";
        ClydeTray = "m5";

        //GimbalVertical = "m6";
        ServoStop = "s1";

        IMU = "imu";
        Ultra = "u1";
        IRDistance = "ir1";
        Lightone = "l1";
        Lighttwo = "l2";
        Touch = "t1";
        ContactLeft = "t2";
        ContactRight = "t3";
        Unwinder = "t4";
    }
}
