package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
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
    double limit = 0;
    public DriveToBall(Instruments i , DriveTrain d, double l){
        instruments = i;
        driveTrain = d;
        limit = l;
    }
    public boolean tick(){
        if(yaw == null) {
            yaw = instruments.yaw;
            angleTurning = new AngleTurning(yaw);
        }
        if (instruments.IRdistance >= limit){
            driveTrain.stop();
            return true;
        }
        ArrayList<Float> powers = angleTurning.getDrivePowers(yaw, -0.3f);
        driveTrain.drive(powers.get(0), powers.get(1));
        return false;
    }
}
