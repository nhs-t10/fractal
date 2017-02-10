package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.Team;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
import org.firstinspires.ftc.teamcode.neurons.LineDetection;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.Spacers;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;

import java.util.ArrayList;

/**
 * Created by nhs on 11/16/16.
 */
public class DriveToLine implements Controller {
    private Instruments instruments;
    private DriveTrain driveTrain;
    Spacers spacers;
    private AngleTurning at;
    private LineDetection ld;
    private boolean spacerUp;
    private boolean spacersTouched = false;
    public DriveToLine(Instruments i, DriveTrain d, double angle) {
        this(i, d, angle, true);
    }
    public DriveToLine(Instruments i, DriveTrain d, double angle, boolean spacer){
        instruments = i;
        driveTrain = d;
        at = new AngleTurning(angle);
        ld = new LineDetection();
        spacerUp = spacer;
    }
    public DriveToLine(Instruments i, DriveTrain d, Team t) {
        this(i, d, t == Team.RED ? 60 : -65);
    }
    public boolean tick() {
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
        if (ld.isAtLine(instruments.light1, instruments.light2)) {
            driveTrain.stop();
            spacers.stop();
            return true;
        }
        ArrayList<Float> powers = at.getDrivePowers(instruments.yaw, -0.3f);
        driveTrain.drive(powers.get(0), powers.get(1));
        return false;
    }
}
