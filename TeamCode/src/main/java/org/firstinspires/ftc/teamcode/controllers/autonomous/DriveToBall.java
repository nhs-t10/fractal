package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
import org.firstinspires.ftc.teamcode.neurons.Time;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;

import java.util.ArrayList;

/**
 * Created by Jacob on 1/31/2017.
 */

public class DriveToBall implements Controller{
    DriveTrain driveTrain;
    Instruments instruments;
    private Double yaw;
    private AngleTurning angleTurning;
    private Time.Stopwatch stopwatch;
    double limit = 0;
    double time = 0;
    public DriveToBall(Instruments i , DriveTrain d, double l, double t){
        instruments = i;
        driveTrain = d;
        limit = l;
        stopwatch = new Time.Stopwatch();
        time = t * 1000;
    }
    public boolean tick(){
        if(yaw == null) {
            yaw = instruments.yaw;
            angleTurning = new AngleTurning(yaw);
            stopwatch.start();
        }
        if (instruments.distance <= limit || stopwatch.timeElapsed() >= time){
            driveTrain.stop();
            return true;
        }
        ArrayList<Float> powers = angleTurning.getDrivePowers(yaw, -0.3f);
        driveTrain.drive(powers.get(0), powers.get(1));
        return false;
    }
}
