package com.qualcomm.ftcrobotcontroller.mappings;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by robotics on 4/14/16.
 */
public class Hardware {
    public static DcMotor MotorLeftRear, MotorRightRear;

    private static HardwareMap hardwareMap;

    public static void init(HardwareMap h) {
        hardwareMap = h;

        MotorLeftRear = hardwareMap.dcMotor.get("m1");
        MotorRightRear = hardwareMap.dcMotor.get("m2");
    }
}
