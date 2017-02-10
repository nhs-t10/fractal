package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
import org.firstinspires.ftc.teamcode.neurons.Time;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.Spacers;
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
    private Spacers spacers;
    private boolean backwards = false;
    public boolean spacerUp = false;
    double limit = 0;
    private int count = 0;
    public DriveFromWall(Instruments i, MecanumDrivetrain dt, double l) {
        instruments = i;
        driveTrain = dt;
        limit = Math.abs(l);
        spacers = new Spacers();
        stopwatch = new Time.Stopwatch();
        backwards = (Math.signum(l) == -1);
    }
    public boolean tick() {
        Logger.logLine("d:" + instruments.distance);
        if(yaw == null) {
            yaw = instruments.yaw;
            angleTurning = new AngleTurning(yaw);
            stopwatch.start();
        }
        if (spacerUp){
            if (spacers.isTouchingLeft() || spacers.isTouchingRight()){
                spacers.lowerTimed(500);
                spacerUp = true;
            }
            else spacers.raise();
        }
        if (((!backwards && instruments.distance >= limit) || (backwards && instruments.distance <= limit)) && stopwatch.timeElapsed() > 600) {
            if (count >= 2) {
                driveTrain.stop();
                return true;
            }
            else count++;
        }
        ArrayList<Float> powers = angleTurning.getDrivePowers(yaw, (backwards ? -0.3f : 0.3f));
        driveTrain.drive(powers.get(0), powers.get(1));
        return false;
    }
}
