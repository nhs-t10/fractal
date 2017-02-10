package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
import org.firstinspires.ftc.teamcode.neurons.Time;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;
import org.firstinspires.ftc.teamcode.organs.Spacers;

import java.util.ArrayList;

/**
 * Created by jacob_000 on 11/8/2016.
 */

public class TurnX implements Controller {
    private DriveTrain driveTrain;
    private Instruments instruments;
    private AngleTurning angleTurning;
    private Spacers spacers;
    public boolean started = false;
    private boolean spacerUp;
    private boolean spacersTouched = false;
    public Time.Stopwatch sw = new Time.Stopwatch();
    public TurnX(Instruments i, DriveTrain d, double deg) {
        this(i, d, deg, true);
    }
    public TurnX(Instruments i, DriveTrain d, double deg, boolean spacer){
        instruments = i;
        driveTrain = d;
        angleTurning = new AngleTurning(deg);
        spacerUp = spacer;
        spacers = new Spacers();
    }
    public boolean tick (){
        if(!started) {
            sw.start();
            started = true;
        }
        if (!spacerUp){
            if (spacers.isTouchingLeft() || spacers.isTouchingRight()){
                spacers.lower();
                spacersTouched = true;
            }
            else if (spacersTouched){
                spacers.stop();
                spacerUp = true;
            }
            else spacers.raise();
        }
        ArrayList<Float> values = angleTurning.getPivotPowers(instruments.yaw);
//        Logger.logFile("yaw", instruments.yaw + "," + sw.timeElapsed());
        if (values.get(0) == 0.0 && values.get(1) == 0.0) {
            driveTrain.stop();
            spacers.stop();
            return true;
        }
        driveTrain.drive(values.get(0), values.get(1));
        return false;
    }

}
