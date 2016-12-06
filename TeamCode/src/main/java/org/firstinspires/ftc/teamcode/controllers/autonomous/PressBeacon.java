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
    private Time.Stopwatch sw;
    private boolean startedCount = false;
    private LineAlignment lineAlignment;
    public PressBeacon(Team t, Instruments i, DriveTrain d, Pusher p, TCamera c) {
        instruments = i;
        driveTrain = d;
        pusher = p;
        camera = c;
        sw = new Time.Stopwatch();
        beacon = new BeaconCheck(t);
        angleTurning = new AngleTurning((t == Team.RED ? 180 : 0));
    }
    public boolean tick() {
        if(!startedCount) {
            sw.start();
            startedCount = true;
        }
        Logger.logLine("L1: " + instruments.light1);
        Logger.logLine("L2: " + instruments.light2);
        beacon.update(camera.getAnalysis());
        Logger.logLine(camera.getString());
        if (beacon.isPressed() && sw.timeElapsed() >= 500) {
            Logger.logLine("Done pressing.");
            driveTrain.stop();
            return true;
        }
        ArrayList<Float> powers = angleTurning.getDrivePowers(instruments.yaw, -0.2f);
        driveTrain.drive(powers.get(0), powers.get(1));


        if (beacon.shouldPressLeft()) pusher.pushLeft();
        else pusher.pushRight();


        Logger.logLine((beacon.shouldPressLeft() ? "LEFT" : "RIGHT"));
        return false;
    }
}
