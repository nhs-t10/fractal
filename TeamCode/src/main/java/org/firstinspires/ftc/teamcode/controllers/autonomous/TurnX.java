package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
import org.firstinspires.ftc.teamcode.neurons.Time;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;

import java.util.ArrayList;

/**
 * Created by jacob_000 on 11/8/2016.
 */

public class TurnX implements Controller {
    private DriveTrain driveTrain;
    private Instruments instruments;
    private AngleTurning angleTurning;
    public boolean started = false;
    public Time.Stopwatch sw = new Time.Stopwatch();
    public TurnX(Instruments i, DriveTrain d, double deg){
        instruments = i;
        driveTrain = d;
        angleTurning = new AngleTurning(deg);
    }
    public boolean tick (){
        if(!started) {
            sw.start();
            started = true;
        }
        ArrayList<Float> values = angleTurning.getPivotPowers(instruments.yaw);
//        Logger.logFile("yaw", instruments.yaw + "," + sw.timeElapsed());
        if (values.get(0) == 0.0 && values.get(1) == 0.0) {
            driveTrain.stop();
            return true;
        }
        driveTrain.drive(values.get(0), values.get(1));
        return false;
    }

}
