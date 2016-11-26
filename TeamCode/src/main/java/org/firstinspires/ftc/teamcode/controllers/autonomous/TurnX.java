package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
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
    public int test;
    public TurnX(Instruments i, DriveTrain d, double deg, int test) {
        instruments = i;
        driveTrain = d;
        angleTurning = new AngleTurning(deg);
    }
    public boolean tick (){
        ArrayList<Float> values = angleTurning.getPivotPowers(instruments.yaw);
        if (values.get(0) == 0.0 && values.get(1) == 0.0) {
            driveTrain.stop();
            return true;
        }
        Logger.logLine("Test Number: " + test);
        driveTrain.drive(values.get(0), values.get(1));
        return false;
    }

}
