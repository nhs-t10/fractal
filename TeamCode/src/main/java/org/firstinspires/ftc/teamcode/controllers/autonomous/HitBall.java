package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.Team;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;

import java.util.ArrayList;

/**
 * Created by Jacob on 1/20/2017.
 */

public class HitBall implements Controller {
    private DriveTrain driveTrain;
    private Instruments instruments;
    private AngleTurning angleTurning;

    public HitBall(Instruments i, DriveTrain d, Team t){
        instruments = i;
        driveTrain = d;
        angleTurning = new AngleTurning((t == Team.RED ? -135 : 135));
    }
    public boolean tick(){
        if (instruments.IRdistance >= 2.6){
            driveTrain.stop();
            return true;
        }
        ArrayList<Float> powers = angleTurning.getDrivePowers(instruments.yaw, -0.1f);
        driveTrain.drive(powers.get(0), powers.get(1));
        return false;
    }
//    return false;
}
