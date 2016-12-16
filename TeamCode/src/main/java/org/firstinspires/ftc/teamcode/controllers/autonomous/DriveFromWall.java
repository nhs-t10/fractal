package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
import org.firstinspires.ftc.teamcode.neurons.Time;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;

import java.util.ArrayList;

/**
 * Created by nhs on 11/17/16.
 */
public class DriveFromWall implements Controller {
    MecanumDrivetrain driveTrain;
    Instruments instruments;
    private Double yaw;
    private AngleTurning angleTurning;
    private Time.Stopwatch stopwatch;
    double limit = 0;
    public DriveFromWall(Instruments i, MecanumDrivetrain dt, double l) {
        instruments = i;
        driveTrain = dt;
        limit = l;
        stopwatch = new Time.Stopwatch();
    }
    public boolean tick() {
        Logger.logLine("d:" + instruments.distance);
        if(yaw == null) {
            yaw = instruments.yaw;
            angleTurning = new AngleTurning(yaw);
            stopwatch.start();
        }
        if (instruments.distance >= limit && instruments.IRdistance <= 2.5) {
            driveTrain.stop();
            return true;
        }
        ArrayList<Float> powers = angleTurning.getDrivePowers(yaw, 0.3f);
        driveTrain.drive(powers.get(0), powers.get(1));
        return false;
    }
}
