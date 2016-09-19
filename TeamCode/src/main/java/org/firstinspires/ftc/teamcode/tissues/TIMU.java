package org.firstinspires.ftc.teamcode.tissues;

import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import com.qualcomm.hardware.adafruit.BNO055IMU;

/**
 * Created by max on 4/17/16.
 */

/**
 * If for any reasons the IMU is giving incorrect data, see
 * https://github.com/ftctechnh/ftc_app/blob/master/FtcRobotController/src/main/java/org/firstinspires/ftc/robotcontroller/external/samples/SensorAdafruitIMUCalibration.java
 * (READ THE DOCUMENTATION AT THE TOP OF THE FILE!)
 */
public class TIMU implements Component {
    private BNO055IMU imu;

    private Orientation angles;

    public TIMU(String map) {
        BNO055IMU.Parameters params = new BNO055IMU.Parameters();
        params.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        params.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;

        imu = Hardware.getHardwareMap().get(BNO055IMU.class, map);
        imu.initialize(params);
    }

    /**
     * Gets the yaw of the IMU
     * @return yaw value read by the IMU
     */
    public double getYaw() {
        updateValues();
        return 180 + angles.firstAngle;
    }

    /**
     * Gets the roll of the IMU
     * @return roll value read by the IMU
     */
    public double getRoll() {
        updateValues();
        return 180 + angles.secondAngle;
    }

    /**
     * Gets the pitch of the IMU
     * @return pitch value read by the IMU
     */
    public double getPitch() {
        updateValues();
        return 180 + angles.thirdAngle;
    }

    public String getName(){
        return "Adafruit-IMU-BNO055";
    }

    public Boolean test() {
        Logger.logLine(this.getName() + " yaw:" + this.getYaw() + " pitch:" + getPitch() + " roll:" + getRoll());
        return true;
    }

    private void updateValues() {
        //Z = yaw, Y = roll, X = pitch
        angles = imu.getAngularOrientation().toAxesReference(AxesReference.INTRINSIC).toAxesOrder(AxesOrder.ZYX);
    }
}