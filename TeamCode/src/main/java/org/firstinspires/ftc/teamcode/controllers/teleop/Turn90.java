package org.firstinspires.ftc.teamcode.controllers.teleop;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;
import org.firstinspires.ftc.teamcode.statics.ControlParser;
import org.firstinspires.ftc.teamcode.statics.Controls;

import java.util.ArrayList;

/**
 * Created by jacob_000 on 11/16/2016.
 */

public class Turn90 implements Controller{
    private DriveTrain driveTrain;
    private Instruments instruments;
    private AngleTurning angleTurning;
    public Turn90 (Instruments i, DriveTrain d) {
        instruments = i;
        driveTrain = d;
    }
    public boolean tick (){
        if (ControlParser.button(Controls.Turn90Right)) {
            angleTurning = new AngleTurning(90);
            while (Math.abs(angleTurning.getError(instruments.yaw)) > .3) {
                ArrayList<Float> values = angleTurning.getPivotPowers(instruments.yaw);
                driveTrain.drive(values.get(0), values.get(1));
            }
            return false;
        }
        else if (ControlParser.button(Controls.Turn90Left)) {
            angleTurning = new AngleTurning(-90);
            while (Math.abs(angleTurning.getError(instruments.yaw)) > .3) {
                ArrayList<Float> values = angleTurning.getPivotPowers(instruments.yaw);
                driveTrain.drive(values.get(0), values.get(1));
            }
            return false;
        }
        else
            driveTrain.stop();
        return false;
    }
}
