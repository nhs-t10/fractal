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

public class ZieglerNichols implements Controller{
        private DriveTrain driveTrain;
        private Instruments instruments;
        private AngleTurning angleTurning;
        private PorpotionalTuning porpotionalTuning;
        private Time.Stopwatch sw;
        private int trial = 1;
        private boolean startedCount = false;
        private boolean success = false;
        public ZieglerNichols(Instruments i, DriveTrain d, PorpotionalTuning pt) {
            instruments = i;
            driveTrain = d;
            angleTurning = new AngleTurning(instruments.yaw + 45);
            porpotionalTuning = pt;
            sw = new Time.Stopwatch();
        }
        public boolean tick () {
            if (success){
                Logger.logLine("Kp: " + porpotionalTuning.KP*0.6);
                Logger.logLine("Ki: " +  1.2*porpotionalTuning.KP/porpotionalTuning.period);
                Logger.logLine("Kd: " + 3*porpotionalTuning.KP*porpotionalTuning.period/40);
            }
            else {
                Logger.logLine("ZN");
                Logger.logLine("period: " + porpotionalTuning.period);
                ArrayList<Float> values = angleTurning.getTuningPivotPowers(instruments.yaw, porpotionalTuning.KP * 0.6, 1.2 * porpotionalTuning.KP / porpotionalTuning.period, 3 * porpotionalTuning.KP * porpotionalTuning.period / 40);
                Logger.logLine("power: " + values.get(0));
                if (!startedCount) {
                    sw.start();
                    startedCount = true;
                }
                if (sw.timeElapsed() > 4000) {
                    if (values.get(0) == 0) {
                        if (trial == 1) {
                            sw.reset();
                            angleTurning = new AngleTurning(instruments.yaw + 180);
                        }
                        if (trial == 2) {
                            sw.reset();
                            angleTurning = new AngleTurning(instruments.yaw + 10);
                        } else {success = true;}
                        trial++;
                        return false;
                    }
                    else return true;
                }
                driveTrain.drive(values.get(0), values.get(1));
            }
            return false;
        }
    }
