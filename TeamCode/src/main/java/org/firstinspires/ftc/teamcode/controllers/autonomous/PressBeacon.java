package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.Team;
import org.firstinspires.ftc.teamcode.neurons.BeaconCheck;
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
    public PressBeacon(Team t, DriveTrain d, Pusher p, TCamera c) {
        driveTrain = d;
        pusher = p;
        camera = c;
        beacon = new BeaconCheck(t);
    }
    public boolean tick() {
        beacon.update(camera.getAnalysis());
        if (beacon.isPressed()) {
            driveTrain.stop();
            return true;
        }

        if (beacon.shouldPressLeft()) pusher.pushLeft();
        else pusher.pushRight();

        driveTrain.goForward(1f);
        return false;
    }
}
