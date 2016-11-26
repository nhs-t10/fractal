package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
import org.firstinspires.ftc.teamcode.neurons.Time;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;

import java.util.ArrayList;

/**
 * Created by jacob_000 on 11/25/2016.
 */

public class DerivativeTuning implements Controller{
    private DriveTrain driveTrain;
    private Instruments instruments;
    private AngleTurning angleTurning;
    private PorpotionalTuning porpotionalTuning;
    private IntegralTuning integralTuning;
    private boolean sign;
    private int oscCount = -1;
    private Time.Stopwatch sw;
    private boolean startedCount = false;
    public double KD = 0.1;
    public DerivativeTuning(Instruments i, DriveTrain d, PorpotionalTuning pt, IntegralTuning it) {
        instruments = i;
        driveTrain = d;
        angleTurning = new AngleTurning(instruments.yaw + 45);
        porpotionalTuning = pt;
        integralTuning = it;
        sw = new Time.Stopwatch();
    }
    public boolean tick (){
        if(!startedCount) {
            sw.start();
            startedCount = true;
        }
        ArrayList<Float> values = angleTurning.getTuningPivotPowers(instruments.yaw, porpotionalTuning.KP/2, integralTuning.KI, KD);
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
        if (sw.timeElapsed() > 5000){
            if (oscCount > 3){
                KD = KD - 0.2;
                return true;
            }
            startedCount = false;
            angleTurning = new AngleTurning(instruments.yaw + 45);
            KD = KD + 0.1;
        }
        driveTrain.drive(values.get(0), values.get(1));
        return false;
    }
}

