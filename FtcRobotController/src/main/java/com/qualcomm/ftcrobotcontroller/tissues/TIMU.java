package com.qualcomm.ftcrobotcontroller.tissues;

import com.qualcomm.ftcrobotcontroller.debug.Component;
import com.qualcomm.ftcrobotcontroller.debug.Logger;
import com.qualcomm.ftcrobotcontroller.lib.AdafruitIMU;
import com.qualcomm.ftcrobotcontroller.statics.Hardware;
import com.qualcomm.robotcore.exception.RobotCoreException;

/**
 * Created by max on 4/17/16.
 */
public class TIMU implements Component {
    private AdafruitIMU imu;
    public String getName(){return "IMU";}
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
            Logger.logLine("IMU Initialized");
        } catch(RobotCoreException rce) {
            Logger.logLine(rce.toString(), 1);
        }
    }

    /**
     * Gets the yaw of the IMU
     * @return yaw value read by the IMU
     */
    public double getYaw() {
        imu.getIMUGyroAngles(rollAngle, pitchAngle, yawAngle);
        return 180 + yawAngle[0];
    }

    /**
     * Gets the roll of the IMU
     * @return roll value read by the IMU
     */
    public double getRoll() {
        imu.getIMUGyroAngles(rollAngle, pitchAngle, yawAngle);
        return 180 + rollAngle[0];
    }

    /**
     * Gets the pitch of the IMU
     * @return pitch value read by the IMU
     */
    public double getPitch() {
        imu.getIMUGyroAngles(rollAngle, pitchAngle, yawAngle);
        return 180 + pitchAngle[0];
    }

    public Boolean test() {
        Logger.logLine(imu.getDeviceName() + " yaw:" + this.getYaw() + " pitch:" + getPitch() + " roll:" + getRoll());
        return true;
    }
}
