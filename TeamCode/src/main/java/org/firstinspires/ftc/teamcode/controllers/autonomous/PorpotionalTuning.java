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
    public double KP = 4;
    public double period;
    private DriveTrain driveTrain;
    private Instruments instruments;
    private AngleTurning angleTurning;
    private boolean sign;
    private int oscCount = -1;
    private Time.Stopwatch sw;
    private boolean trigger = false;
    private boolean startedCount = false;
    public PorpotionalTuning(Instruments i, DriveTrain d) {
        instruments = i;
        driveTrain = d;
        angleTurning = new AngleTurning(instruments.yaw);
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
        if ((values.get(0) > 0) == !sign) {
            oscCount ++;
            sign = !sign;
            if (trigger){
                if(oscCount == 1){
                    sw.start();
                }
                else if (oscCount >= 3){
                    period = sw.timeElapsed() / 1000;
                    Logger.logLine("period: " + period);
                    return true;
                }
            }
        }
        Logger.logLine("Oscilation: " + oscCount);
        Logger.logLine("trigger" + trigger);
        if (oscCount > 5){
            oscCount = -1;
            angleTurning = new AngleTurning(instruments.yaw + 90);
            sw.reset();
            trigger = true;
        }
        else if (values.get(0) == 0 || sw.timeElapsed() > 7000){
            KP = KP + 0.1;
            oscCount = -1;
            angleTurning = new AngleTurning(instruments.yaw + 90);
            sw.reset();
        }
        driveTrain.drive(values.get(0), values.get(1));
        return false;
    }

}
