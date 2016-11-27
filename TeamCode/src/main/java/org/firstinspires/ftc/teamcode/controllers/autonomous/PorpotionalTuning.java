package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
import org.firstinspires.ftc.teamcode.neurons.Time;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;


import java.util.ArrayList;

/**
 * Created by jacob_000 on 11/24/2016.
 */

public class PorpotionalTuning implements Controller {
    public double KP = 0.1;
    public double period;
    private DriveTrain driveTrain;
    private Instruments instruments;
    private AngleTurning angleTurning;
    private boolean sign;
    private int oscCount = -1;
    private double deg = instruments.yaw + 45;
    private Time.Stopwatch sw;
    private boolean trigger = false;
    private boolean startedCount = false;
    public PorpotionalTuning(Instruments i, DriveTrain d) {
        instruments = i;
        driveTrain = d;
        angleTurning = new AngleTurning(deg);
        sw = new Time.Stopwatch();
    }
    public boolean tick (){
        if(!startedCount && !trigger) {
            sw.start();
            startedCount = true;
        }
        ArrayList<Float> values = angleTurning.getTuningPivotPowers(instruments.yaw, KP, 0, 0);
        if (oscCount == -1){
            sign = (values.get(0) > 0);
            oscCount++;
        }
        if (values.get(0) > 0 && !sign) {
            oscCount ++;
            sign = true;
            if (trigger){
                if(!startedCount){
                    sw.start();
                    startedCount = true;
                }
                else {
                    period = sw.timeElapsed();
                    return true;
                }
            }
        }
        else if (values.get(0) < 0 && sign) {
            oscCount ++;
            sign = false;
            if (trigger){
                if(!startedCount){
                    sw.start();
                    startedCount = true;
                }
                else {
                    period = sw.timeElapsed();
                    return true;
                }
            }
        }
        if (values.get(0) == 0){
            KP = KP + 0.1;
            oscCount = -1;
            deg = deg + 45;
            angleTurning = new AngleTurning(deg);
            sw = new Time.Stopwatch();
        }
        else if (sw.timeElapsed() > 6 && oscCount > 2){
            oscCount = -1;
            deg = deg + 45;
            angleTurning = new AngleTurning(deg);
            sw = new Time.Stopwatch();
            trigger = true;
        }
        driveTrain.drive(values.get(0), values.get(1));
        return false;

    }

}
