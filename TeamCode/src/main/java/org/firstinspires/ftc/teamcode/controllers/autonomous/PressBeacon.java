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
    private Time.Stopwatch sr;
    private boolean startedCount = false;
    private boolean servoBusy = false;
    private boolean isCloseEnough = false;
    private LineAlignment lineAlignment;
    public PressBeacon(Team t, Instruments i, DriveTrain d, Pusher p, TCamera c) {
        instruments = i;
        driveTrain = d;
        pusher = p;
        camera = c;
        sw = new Time.Stopwatch();
        sr = new Time.Stopwatch();
        beacon = new BeaconCheck(t);
        angleTurning = new AngleTurning((t == Team.RED ? 90 : -90));
    }
    public boolean tick() {
        if(!startedCount) {
            sw.start();
            startedCount = true;
        }
        beacon.update(camera.getAnalysis());
        Logger.logLine(camera.getString());
        if (instruments.IRdistance >= 3.0 && !isCloseEnough){
            isCloseEnough = true;
        }
        if (beacon.isPressed() && sw.timeElapsed() >= 200 && isCloseEnough) {
            driveTrain.stop();
            return true;
        }

        if (beacon.shouldPressLeft()) {
            pusher.pushLeft();
            if (!servoBusy) { //if haven't started moving servo
                sr.start();
                servoBusy = true;
            }
            if (sr.timeElapsed() <= 500 && instruments.IRdistance >= 2.8) { //if moving servo
                driveTrain.stop();
                return false;
            }
        }
        else if (beacon.shouldPressRight()) {
            if (!servoBusy) {
                sr.start();
                servoBusy = true;
            }
            pusher.pushRight();
            if (sr.timeElapsed() <= 500 && instruments.IRdistance >= 2.8) {
                driveTrain.stop();
                return false;
            }
        }

        ArrayList<Float> powers = angleTurning.getDrivePowers(instruments.yaw, -0.2f);
        driveTrain.drive(powers.get(0), powers.get(1));

        Logger.logLine((beacon.shouldPressLeft() ? "LEFT" : "RIGHT"));
        return false;
    }
}
