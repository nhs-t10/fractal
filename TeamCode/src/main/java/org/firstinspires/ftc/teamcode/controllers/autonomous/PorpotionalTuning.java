package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;


import java.util.ArrayList;

/**
 * Created by jacob_000 on 11/24/2016.
 */

public class PorpotionalTuning implements Controller {
    private DriveTrain driveTrain;
    private Instruments instruments;
    private AngleTurning angleTurning;
    public int test;
    public double KP = 0.1;
    private boolean sign;
    private int oscCount = -1;
    private double deg = instruments.yaw + 45;
    public PorpotionalTuning(Instruments i, DriveTrain d) {
        instruments = i;
        driveTrain = d;
        angleTurning = new AngleTurning(deg);
    }
    public boolean tick (){
        ArrayList<Float> values = angleTurning.getTuningPivotPowers(instruments.yaw, KP, 0, 0);
        if (oscCount == -1){
            if (values.get(0) > 0){sign = true;}
            else sign = false;
            oscCount++;
        }
        if (values.get(0) > 0 && !sign) {
            oscCount ++;
            sign = true;
        }
        else if (values.get(0) < 0 && sign) {
            oscCount ++;
            sign = false;
        }
        if (oscCount == 2){
            return true;
        }
        if (values.get(0) == 0){
            KP = KP + 0.1;
            oscCount = -1;
            deg = deg + 45;
            angleTurning = new AngleTurning(deg);
        }
        driveTrain.drive(values.get(0), values.get(1));
        return false;

    }

}
