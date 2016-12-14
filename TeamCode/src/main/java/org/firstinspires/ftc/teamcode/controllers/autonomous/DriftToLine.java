package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.Team;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
import org.firstinspires.ftc.teamcode.neurons.LineDetection;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;

import java.util.ArrayList;

/**
 * Created by nhs on 11/16/16.
 */
public class DriftToLine implements Controller {
    private Instruments instruments;
    private MecanumDrivetrain driveTrain;
    private LineDetection ld;
    private Team team;
    private float speed;
    public DriftToLine(Instruments i, MecanumDrivetrain d, Team t) {
        this(i, d, (t == Team.RED ? 0.8f : -0.8f));
    }
    public DriftToLine(Instruments i, MecanumDrivetrain d, float s) {
        instruments = i;
        driveTrain = d;
        speed = s;
        ld = new LineDetection();
    }
    public boolean tick() {
        if (ld.isAtLine(instruments.light1, instruments.light2)) {
            driveTrain.stop();
            return true;
        }
        // "too close" fallback
        if (instruments.distance <= 0.04) driveTrain.goForward(0.5f);
        else driveTrain.driveSideways(speed);
        return false;
    }
}
