package com.qualcomm.ftcrobotcontroller.tissues;

import com.qualcomm.ftcrobotcontroller.debug.Component;
import com.qualcomm.ftcrobotcontroller.lib.AdafruitIMU;
import com.qualcomm.ftcrobotcontroller.statics.Hardware;
import com.qualcomm.robotcore.exception.RobotCoreException;

/**
 * Created by max on 4/17/16.
 */
public class TIMU implements Component {
    private AdafruitIMU imu;
    volatile double[] rollAngle = new double[2], pitchAngle = new double[2], yawAngle = new double[2];

    public TIMU(String map) {
        try {
            imu = new AdafruitIMU(
                    Hardware.getHardwareMap(),
                    map,
                    (byte)(AdafruitIMU.BNO055_ADDRESS_A * 2),
                    (byte)AdafruitIMU.OPERATION_MODE_IMU
            );
            imu.startIMU();
        } catch(RobotCoreException rce) {
            throw new Error("Encountered an error.");
        }
    }

    public double getYaw() {
        imu.getIMUGyroAngles(rollAngle, pitchAngle, yawAngle);
        return 180 + yawAngle[0];
    }

    public double getRoll() {
        imu.getIMUGyroAngles(rollAngle, pitchAngle, yawAngle);
        return 180 + rollAngle[0];
    }

    public double getPitch() {
        imu.getIMUGyroAngles(rollAngle, pitchAngle, yawAngle);
        return 180 + pitchAngle[0];
    }

    public String test() {
        return imu.getDeviceName() + " yaw:" + this.getYaw() + " pitch:" + getPitch() + " roll:" + getRoll();
    }
}
