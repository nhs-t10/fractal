package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
import org.firstinspires.ftc.teamcode.neurons.LineDetection;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;

import java.util.ArrayList;

/**
 * Created by nhs on 11/16/16.
 */
public class DriveToLine implements Controller {
    private Instruments instruments;
    private DriveTrain driveTrain;
    private AngleTurning at;
    private LineDetection ld;
    public DriveToLine(Instruments i, DriveTrain d) {
        instruments = i;
        driveTrain = driveTrain;
        at = new AngleTurning(-120);
        ld = new LineDetection();
    }
    public boolean tick() {
        if (ld.isAtLine(instruments.light1, instruments.light2)) {
            driveTrain.stop();
            return true;
        }
        ArrayList<Float> powers = at.getDrivePowers(instruments.yaw);
        driveTrain.drive(powers.get(0), powers.get(1));
        return false;
    }
}
