package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.Team;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
import org.firstinspires.ftc.teamcode.neurons.BeaconCheck;
import org.firstinspires.ftc.teamcode.neurons.LineAlignment;
import org.firstinspires.ftc.teamcode.neurons.Time;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.Pusher;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;
import org.firstinspires.ftc.teamcode.tissues.TCamera;

import java.util.ArrayList;

/**
 * Created by max on 11/3/16.
 *
 * Drives up to the beacon and presses it.
 */
public class PressBeacon implements Controller {
    private DriveTrain driveTrain;
    private Instruments instruments;
    private TCamera camera;
    private Pusher pusher;
    private BeaconCheck beacon;
    private AngleTurning angleTurning;

    // STATE:
    private boolean detectedBeaconStatus = false;
    private boolean isPressingLeft = false;

    private int frames = 0;
    private int isLeft = 0;

    public PressBeacon(Team t, Instruments i, DriveTrain d, Pusher p, TCamera c) {
        instruments = i;
        driveTrain = d;
        pusher = p;
        camera = c;
        beacon = new BeaconCheck(t);
        angleTurning = new AngleTurning((t == Team.RED ? 90 : -90));
    }
    //        sw = new Time.Stopwatch();
    @Deprecated
    public PressBeacon(Team t, Instruments i, DriveTrain d, Pusher p, TCamera c, boolean rolling) {
        this(t, i, d, p, c);
    }

    @Deprecated
    public PressBeacon(boolean testing, Team t, Instruments i, DriveTrain d, Pusher p, TCamera c) {
        instruments = i;
        driveTrain = d;
        pusher = p;
        camera = c;
        beacon = new BeaconCheck(t);
        angleTurning = new AngleTurning(180);
    }
    private double updateRolling() {
        if (beacon.shouldPressLeft()) isLeft++;
        if (beacon.shouldPressLeft() || beacon.shouldPressRight()) frames++;
        Logger.logLine("Rolling left probability: " + (double) isLeft / frames);
        return (double) isLeft/frames;
    }
    public boolean tick() {
        beacon.update(camera.getAnalysis());
        Logger.logLine(camera.getString());

        if (!detectedBeaconStatus && instruments.IRdistance >= 1.1) {
            double leftProb = updateRolling();
            driveTrain.stop();
            if (frames >= 15) {
                isPressingLeft = (leftProb >= 0.5d);
                detectedBeaconStatus = true;
            }
            return false;

        }
        if (detectedBeaconStatus && instruments.IRdistance >= 1.95) {
            driveTrain.stop();
            if (isPressingLeft) pusher.pushLeft();
            else pusher.pushRight();
            return true;
        }

        ArrayList<Float> powers = angleTurning.getDrivePowers(instruments.yaw, -0.1f);
        driveTrain.drive(powers.get(0), powers.get(1));
        return false;
    }
}
