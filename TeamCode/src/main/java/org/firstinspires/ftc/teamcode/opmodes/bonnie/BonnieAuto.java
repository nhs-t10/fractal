package org.firstinspires.ftc.teamcode.opmodes.bonnie;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.Team;
import org.firstinspires.ftc.teamcode.controllers.autonomous.DriftToLine;
import org.firstinspires.ftc.teamcode.controllers.autonomous.DriveFromWall;
import org.firstinspires.ftc.teamcode.controllers.autonomous.DriveToLine;
import org.firstinspires.ftc.teamcode.controllers.autonomous.FlickOnce;
import org.firstinspires.ftc.teamcode.controllers.autonomous.PressBeacon;
import org.firstinspires.ftc.teamcode.controllers.autonomous.TimeFromWall;
import org.firstinspires.ftc.teamcode.controllers.autonomous.TurnX;
import org.firstinspires.ftc.teamcode.controllers.teleop.AlignToNearest;
import org.firstinspires.ftc.teamcode.controllers.tests.Stall;
import org.firstinspires.ftc.teamcode.opmodes.T10Autonomous;
import org.firstinspires.ftc.teamcode.organs.Flicker;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.Pusher;
import org.firstinspires.ftc.teamcode.organs.Spinner;
import org.firstinspires.ftc.teamcode.organs.Stopper;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TCamera;

/**
 * Created by nhs on 11/15/16.
 */
public abstract class BonnieAuto extends T10Autonomous {
    private TCamera camera;
    public Team team;
    @Override
    public void registration() {
        setTeam();
        camera = new TCamera();
        final MecanumDrivetrain driveTrain = new MecanumDrivetrain();
        Instruments instruments = new Instruments();
        instruments.start();
        Pusher pusher = new Pusher();
        Flicker flicker = new Flicker(false, -1);
        final Stopper stopper = new Stopper();
        final Spinner spinner = new Spinner(-1);
        final Spinner liftSpinner = new Spinner(Hardware.LiftSpinner, 1);
        //Adv ance from the wall and flick
        registerController(new DriveFromWall(instruments, driveTrain, (team == Team.RED ? 0.29 : 0.28)));
        registerController(new TurnX(instruments, driveTrain, (team == Team.RED ? 90 : 90)));
        registerController(new FlickOnce(flicker));
        registerController(new Controller() {
            @Override
            public boolean tick() {
                liftSpinner.toggle(1);
                return true;
            }
        });
        registerController(new Controller() {
            @Override
            public boolean tick() {
                stopper.open();
                return true;
            }
        });
        registerController(new Stall(3000));
        registerController(new FlickOnce(flicker));
        registerController(new Controller() {
            @Override
            public boolean tick() {
                liftSpinner.toggle(1);
                return true;
            }
        });
        //Drive to the line
        registerController(new DriveToLine(instruments, driveTrain, team));
        //Go for 1st beacon
        registerController(new TurnX(instruments, driveTrain, (team == Team.RED ? 90 : -90)));
        registerController(new DriftToLine(instruments, driveTrain, team));
        registerController(new TurnX(instruments, driveTrain, (team == Team.RED ? 90 : -90)));
        registerController(new PressBeacon(team,instruments, driveTrain, pusher, camera));
//        registerController(new DriveFromWall(instruments, driveTrain, 0.1));
        //Shift backwards, sideways
        registerController(new Controller() {
            @Override
            public boolean tick() {
                driveTrain.goForward(0.5f);
                return true;
            }
        });
        registerController(new Stall(300));
        registerController(new Controller() {
            @Override
            public boolean tick() {
                driveTrain.stop();
                return true;
            }
        });
        registerController(new Controller() {
            @Override
            public boolean tick() {
                driveTrain.driveSideways((team == Team.RED ? 0.5f : -0.5f));
                return true;
            }
        });
        registerController(new Stall(500));
        registerController(new Controller() {
            @Override
            public boolean tick() {
                driveTrain.stop();
                return true;
            }
        });
        //Go for 2nd beacon
        registerController(new DriveToLine(instruments, driveTrain, 0));
        registerController(new TurnX(instruments, driveTrain, (team == Team.RED ? 90 : -90)));
        registerController(new DriftToLine(instruments, driveTrain, team));
        registerController(new TurnX(instruments, driveTrain, (team == Team.RED ? 90 : -90)));
        registerController(new PressBeacon(team,instruments, driveTrain, pusher, camera));
        //LAST STEP: Align perfectly to a wall. Necessary for driver controlled period so we have a calibrated IMU!!
        registerController(new AlignToNearest(driveTrain, instruments));
    }
    public abstract void setTeam();
    @Override
    public void stop() {
        camera.stop();
    }
}
