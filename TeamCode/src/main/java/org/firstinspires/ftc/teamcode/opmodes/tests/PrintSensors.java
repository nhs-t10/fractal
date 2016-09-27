package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.opmodes.T10Opmode;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TIMU;
import org.firstinspires.ftc.teamcode.tissues.TUltra;

/**
 * Created by robotics on 9/27/16.
 */
@TeleOp(name="Sensor Tester", group="Testers")
public class PrintSensors extends T10Opmode {
    TIMU imu;
    TUltra ultra;

    @Override
    public void run() {
        imu = new TIMU(Hardware.IMU);
        ultra = new TUltra(Hardware.Ultra);
    }

    @Override
    public void tick() {
        Logger.logLine("P:" + imu.getPitch() + " R:" + imu.getRoll() + " Y:" + imu.getYaw());
        Logger.logLine("Ultra: " + ultra.distance());
    }
}
