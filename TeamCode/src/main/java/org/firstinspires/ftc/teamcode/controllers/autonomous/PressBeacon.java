package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.Team;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.BeaconCheck;
import org.firstinspires.ftc.teamcode.neurons.Time;
import org.firstinspires.ftc.teamcode.organs.Pusher;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;
import org.firstinspires.ftc.teamcode.tissues.TCamera;

/**
 * Created by max on 11/3/16.
 *
 * Drives up to the beacon and presses it.
 */
public class PressBeacon implements Controller {
    private DriveTrain driveTrain;
    private TCamera camera;
    private Pusher pusher;
    private BeaconCheck beacon;
    private Time.Stopwatch sw;
    private boolean startedCount = false;
    public PressBeacon(Team t, DriveTrain d, Pusher p, TCamera c) {
        driveTrain = d;
        pusher = p;
        camera = c;
        sw = new Time.Stopwatch();
        beacon = new BeaconCheck(t);
    }
    public boolean tick() {
        if(!startedCount) {
            sw.start();
            startedCount = true;
        }
        beacon.update(camera.getAnalysis());
        Logger.logLine(camera.getString());
        if (beacon.isPressed() && sw.timeElapsed() >= 500) {
            Logger.logLine("Done pressing.");
            driveTrain.stop();
            return true;
        }

        if (beacon.shouldPressLeft()) pusher.pushLeft();
        else pusher.pushRight();

        driveTrain.goBackward(0.5f);
        Logger.logLine((beacon.shouldPressLeft() ? "LEFT" : "RIGHT"));
        return false;
    }
}
