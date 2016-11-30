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
    public double KI = 0.1;
    private DriveTrain driveTrain;
    private Instruments instruments;
    private AngleTurning angleTurning;
    private PorpotionalTuning porpotionalTuning;
    private Time.Stopwatch sw;
    private boolean startedCount = false;
    private int oscCount = -1;
    private int trial = 1;
    private boolean sign;
    private boolean findStable = false;
    private boolean endTask = false;
    public IntegralTuning(Instruments i, DriveTrain d, PorpotionalTuning pt) {
        instruments = i;
        driveTrain = d;
        angleTurning = new AngleTurning(instruments.yaw + 90);
        porpotionalTuning = pt;
        sw = new Time.Stopwatch();
    }
    public boolean tick () {
        if(!startedCount) {
            sw.start();
            startedCount = true;
        }
        ArrayList<Float> values = angleTurning.getTuningPivotPowers(instruments.yaw, porpotionalTuning.KP/2, KI, 0);
        if (oscCount == -1){
            sign = (values.get(0) > 0);
            oscCount++;
        }
        if (oscCount > 5){
            findStable = true;
        }
        else if (sw.timeElapsed() > 4000){
            if (values.get(0) == 0){
                if (trial == 1) {
                    sw.reset();
                    angleTurning = new AngleTurning(instruments.yaw + 180);
                }
                else if (trial == 2) {
                    sw.reset();
                    angleTurning = new AngleTurning(instruments.yaw + 10);
                }
                else if (trial == 3) {
                    sw.reset();
                    angleTurning = new AngleTurning(instruments.yaw + 45);
                }
                else {
                    return true;
                }
                trial++;
                return false;
            }
            else if (trial > 1){
                trial = 1;
            }
            else if (findStable){
                KI = KI - 0.05;
            }
            else KI = KI + 0.1;
            angleTurning = new AngleTurning(instruments.yaw + 90);
            sw.reset();
            findStable = false;
        }
        driveTrain.drive(values.get(0), values.get(1));
        return false;
    }
}
