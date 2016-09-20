package org.firstinspires.ftc.teamcode.opmodes.tests;

import org.firstinspires.ftc.teamcode.controllers.teleop.OneStickMecanum;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.opmodes.T10Opmode;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TIMU;

/**
 * Created by will on 9/20/16.
 */
public class MecaIMUTest extends T10Opmode {
    OneStickMecanum osm;
    TIMU imu;
    public void run() {
        osm = new OneStickMecanum();
        imu = new TIMU(Hardware.IMU);
    }

    public void tick() {
        osm.tick();
        Logger.logLine("P:" + imu.getPitch() + " R:" + imu.getRoll() + " Y:" + imu.getYaw());
    }
}
