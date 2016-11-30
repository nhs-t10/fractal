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
    private boolean readyToCall = true;
    private double KD = 0.1;
    public DerivativeTuning(Instruments i, DriveTrain d, PorpotionalTuning pt, IntegralTuning it) {
        instruments = i;
        driveTrain = d;
        angleTurning = new AngleTurning(instruments.yaw + 45);
        porpotionalTuning = pt;
        integralTuning = it;
        sw = new Time.Stopwatch();
    }
    public boolean tick (){
        if (readyToCall){
            Logger.logLine("Kp: " + porpotionalTuning.KP/2);
            Logger.logLine("Ki: " + integralTuning.KI);
            Logger.logLine("Kd: " + KD);
            return false;
        }
        if(!startedCount) {
            sw.start();
            startedCount = true;
        }
        ArrayList<Float> values = angleTurning.getTuningPivotPowers(instruments.yaw, porpotionalTuning.KP/2, integralTuning.KI, KD);
        if (oscCount == -1){
            sign = (values.get(0) > 0);
            oscCount++;
        }
        if ((values.get(0) > 0) == !sign) {
            oscCount ++;
            sign = !sign;
        }
        if (sw.timeElapsed() > 5000){
            if (oscCount > 2){
                KD = KD - 0.2;
                readyToCall = true;
            }
            startedCount = false;
            sw.reset();
            angleTurning = new AngleTurning(instruments.yaw + 90);
            KD += 0.1;
        }
        driveTrain.drive(values.get(0), values.get(1));
        return false;
    }
}

