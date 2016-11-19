package org.firstinspires.ftc.teamcode.controllers.teleop;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;
import org.firstinspires.ftc.teamcode.statics.ControlParser;
import org.firstinspires.ftc.teamcode.statics.Controls;

import java.util.ArrayList;

/**
 * Created by jacob_000 on 11/15/2016.
 */

public class DriveRight implements Controller {
    private DriveTrain driveTrain;
    private Instruments instruments;
    private AngleTurning angleTurning;
    public DriveRight (Instruments i, DriveTrain d) {
        instruments = i;
        driveTrain = d;
        angleTurning = new AngleTurning(-90);
    }
    public boolean tick (){
        ArrayList<Float> values = angleTurning.getDrivePowers(instruments.yaw);
        if (!ControlParser.button(Controls.DriveRight)) {
            driveTrain.stop();
        }
        else driveTrain.drive(values.get(0), values.get(1));
        return false;
    }
}
