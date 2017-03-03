package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.Team;
import org.firstinspires.ftc.teamcode.neurons.LineDetection;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.statics.Hardware;

/**
 * Created by nhs on 11/16/16.
 */
public class DriftToLine implements Controller {
    private Instruments instruments;
    private MecanumDrivetrain driveTrain;
    private LineDetection ld;
    private Team team;
    private float speed;
    private boolean align = false;
    public DriftToLine(Instruments i, MecanumDrivetrain d, Team t, boolean aligning) {
        this(i, d, (t == Team.RED ? 0.3f : -0.3f), aligning);
    }
    public DriftToLine(Instruments i, MecanumDrivetrain d, float s) {
        this(i, d, s, false);
    }
    public DriftToLine(Instruments i, MecanumDrivetrain d, float s, boolean aligning) {
        instruments = i;
        driveTrain = d;
        speed = s;
        ld = new LineDetection();
        align = aligning;
    }
    public boolean tick() {
        if (ld.isAtLine(instruments.light1, instruments.light2)) {
            driveTrain.stop();
            return true;
        }
        // "too close" fallback
        double batteryPower = Hardware.getVoltage();
        if (instruments.distance <= 0.04) driveTrain.goForward(0.5f);
        else driveTrain.driveSideways(speed);
        return false;
    }
}
