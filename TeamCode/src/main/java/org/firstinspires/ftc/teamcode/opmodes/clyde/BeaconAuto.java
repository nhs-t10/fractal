package org.firstinspires.ftc.teamcode.opmodes.clyde;

import org.firstinspires.ftc.teamcode.controllers.Team;
import org.firstinspires.ftc.teamcode.controllers.autonomous.DriveToLine;
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
public abstract class BeaconAuto extends T10Autonomous {
    private TCamera camera;
    public Team team;
    @Override
    public void registration() {
        setTeam();
        camera = new TCamera();
        MecanumDrivetrain driveTrain = new MecanumDrivetrain();
        Instruments instruments = new Instruments();
        instruments.start();
        Pusher pusher = new Pusher();
        registerController(new DriveToLine(instruments, driveTrain, team));
        registerController(new PressBeacon(team, driveTrain, pusher, camera));
    }
    public abstract void setTeam();
    @Override
    public void stop() {
        camera.stop();
    }
}
