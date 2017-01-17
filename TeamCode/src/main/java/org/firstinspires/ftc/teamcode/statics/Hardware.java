package org.firstinspires.ftc.teamcode.statics;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by robotics on 4/14/16.
 */
public class Hardware {
    public static String MotorLeftRear, MotorRightRear, MotorLeftFront, MotorRightFront, Spinner, Flicker, LiftSpinner;

    public static String ServoStop, ServoPusherRight, ServoPusherLeft;

    public static String IMU, Color, Ultra, Lightone, Lighttwo, Touch, IRDistance;

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

        Spinner = "m5";
        Flicker = "m6";
        LiftSpinner = "m7";

        //GimbalVertical = "m6";
        ServoStop = "s1";

        IMU = "imu";
        Ultra = "u1";
        IRDistance = "ir1";
        Lightone = "l1";
        Lighttwo = "l2";
        Touch = "t1";
    }
}
