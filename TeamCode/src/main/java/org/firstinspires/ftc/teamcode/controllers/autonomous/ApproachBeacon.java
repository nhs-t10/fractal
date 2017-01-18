package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.teleop.AlignToNearest;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.Pusher;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;

import java.util.ArrayList;

/**
 * Created by Jack on 1/17/2017.
 */

public class ApproachBeacon implements Controller {
    private DriveTrain driveTrain;
    private Instruments instruments;
    private Pusher pusher;
    private AngleTurning at;
    private boolean inited = false;
    public ApproachBeacon(DriveTrain driveTrain, Instruments instruments, Pusher pusher) {
        this.driveTrain = driveTrain;
        this.instruments = instruments;
        this.pusher = pusher;
    }
    public boolean tick() {
        if (instruments.IRdistance >= 2.4) {
            driveTrain.stop();
            return true;
        }
        if (!inited) {
            at = new AngleTurning(AlignToNearest.findClosest(instruments.yaw));
            inited = true;
        }
        ArrayList<Float> powers = at.getDrivePowers(instruments.yaw, -0.1f);
        driveTrain.drive(powers.get(0), powers.get(1));
        return false;
    }
}
