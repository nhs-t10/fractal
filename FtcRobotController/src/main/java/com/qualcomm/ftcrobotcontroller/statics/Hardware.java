package com.qualcomm.ftcrobotcontroller.statics;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by robotics on 4/14/16.
 */
public class Hardware {
    public static DcMotor MotorLeftRear, MotorRightRear, MotorLeftFront, MotorRightFront;

    public static Servo ServoTop;

    public static String IMU;

    private static HardwareMap hardwareMap;

    public static HardwareMap getHardwareMap() { return hardwareMap; }

    public static void init(HardwareMap h) {
        hardwareMap = h;

        MotorLeftRear = hardwareMap.dcMotor.get("m1");
        MotorRightRear = hardwareMap.dcMotor.get("m2");
        MotorLeftFront = hardwareMap.dcMotor.get("m3");
        MotorRightFront = hardwareMap.dcMotor.get("m4");
        ServoTop = hardwareMap.servo.get("s1");
        IMU = "g1";
    }
}
