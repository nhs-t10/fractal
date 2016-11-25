package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
import org.firstinspires.ftc.teamcode.neurons.Time;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;

import java.util.ArrayList;

/**
 * Created by jacob_000 on 11/25/2016.
 */

public class IntegralTuning implements Controller {
    public double KI = 0;
    private DriveTrain driveTrain;
    private Instruments instruments;
    private AngleTurning angleTurning;
    private PorpotionalTuning porpotionalTuning;
    private Time.Stopwatch sw;
    private boolean startedCount = false;
    private double deg = instruments.yaw + 45;
    private int oscCount = -1;
    private boolean sign;
    public IntegralTuning(Instruments i, DriveTrain d, PorpotionalTuning pt) {
        instruments = i;
        driveTrain = d;
        angleTurning = new AngleTurning(0);
        porpotionalTuning = pt;
        sw = new Time.Stopwatch();
    }
    public boolean tick () {
        if(!startedCount) {
            sw.start();
            startedCount = true;
        }
        ArrayList<Float> values = angleTurning.getTuningPivotPowers(instruments.yaw, porpotionalTuning.KP, KI, 0);
        if (oscCount == -1){
            if (values.get(0) > 0){sign = true;}
            else sign = false;
            oscCount++;
        }
        if (sw.timeElapsed() > 1000 && oscCount > 5){
            KI = KI - 0.1;
            return true;
        }
        if (values.get(0) == 0 || sw.timeElapsed() > 1100){
            KI = KI + 0.1;
            deg = deg + 45;
            angleTurning = new AngleTurning(deg);
        }
        driveTrain.drive(values.get(0), values.get(1));
        return false;
    }
}
