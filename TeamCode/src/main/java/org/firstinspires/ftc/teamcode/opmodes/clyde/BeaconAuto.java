package org.firstinspires.ftc.teamcode.opmodes.clyde;

import org.firstinspires.ftc.teamcode.controllers.Team;
import org.firstinspires.ftc.teamcode.controllers.autonomous.PressBeacon;
import org.firstinspires.ftc.teamcode.opmodes.T10Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.Pusher;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.tissues.TCamera;

/**
 * Created by nhs on 11/15/16.
 */
@Autonomous(name="Red Beacon Auto", group="Autonomous")
public class BeaconAuto extends T10Autonomous {
    private TCamera camera;
    @Override
    public void registration() {
        camera = new TCamera();
        MecanumDrivetrain driveTrain = new MecanumDrivetrain();
        Instruments instruments = new Instruments();
        instruments.start();
        Pusher pusher = new Pusher();
        registerController(new PressBeacon(Team.RED, driveTrain, pusher, camera));
    }
    @Override
    public void stop() {
        camera.stop();
    }
}
