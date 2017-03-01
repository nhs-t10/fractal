package org.firstinspires.ftc.teamcode.opmodes.bonnie;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.Team;
import org.firstinspires.ftc.teamcode.controllers.autonomous.DriveFromWall;
import org.firstinspires.ftc.teamcode.controllers.autonomous.DriveToBall;
import org.firstinspires.ftc.teamcode.controllers.autonomous.TouchFlick;
import org.firstinspires.ftc.teamcode.controllers.autonomous.TurnX;
import org.firstinspires.ftc.teamcode.controllers.tests.Stall;
import org.firstinspires.ftc.teamcode.opmodes.T10Autonomous;
import org.firstinspires.ftc.teamcode.organs.Flicker;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.Pusher;
import org.firstinspires.ftc.teamcode.organs.Spinner;
import org.firstinspires.ftc.teamcode.organs.Stopper;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TTouch;

/**
 * Created by Jacob on 1/31/2017.
 */

public abstract class SecondaryBonnieAuto extends T10Autonomous{
    public Team team;
    private int blueAngle = -60;
    private int redAngle = 47;

    public void registration() {
        setTeam();
        final MecanumDrivetrain driveTrain = new MecanumDrivetrain();
        final Instruments instruments = new Instruments();
        instruments.start();
        Flicker flicker = new Flicker(false, -1);
        final Stopper stopper = new Stopper();
        final Spinner spinner = new Spinner(-1);
        final Pusher pusher = new Pusher();
        final Spinner liftSpinner = new Spinner(Hardware.LiftSpinner, 1);

        //Drive to shooting place
        registerController(new Stall(10000));
        registerController(new DriveFromWall(instruments, driveTrain, (team == Team.RED ? 0.1 : 0.1)));

        registerController(new TurnX (instruments, driveTrain, (team == Team.RED ? 45 : -50)));
        registerController(new DriveToBall (instruments, driveTrain, .12, 1.8));
        registerController(new TurnX(instruments, driveTrain, (team == Team.RED ? 135 : 30)));

        //shooting
        registerController(new Controller() {
            @Override
            public boolean tick() {
                if(!liftSpinner.isOn()) {
                    liftSpinner.toggle(1);
                }

                //super lazy hack :P
                if(!new TTouch(Hardware.Touch).isPressed()) {
                    stopper.open();
                }
                return true;
            }
        });
        registerController(new Stall(500));
        registerController(new Controller() {
            @Override
            public boolean tick() {
                stopper.close();
                return true;
            }
        });
        registerController(new Stall(100));
        registerController(new TouchFlick(flicker, 600, 1500));
        registerController(new Controller() {
            @Override
            public boolean tick() {
                if(liftSpinner.isOn()) {
                    liftSpinner.toggle(1);
                }

                //super lazy hack :P
                if(!new TTouch(Hardware.Touch).isPressed()) {
                    stopper.open();
                }
                return true;
            }
        });

        registerController(new Stall(500));
        registerController(new Controller() {
            @Override
            public boolean tick() {
                stopper.close();
                return true;
            }
        });
        registerController(new Stall(100));
        registerController(new TouchFlick(flicker, 600, 1500));

        //cap ball and parking
        registerController(new TurnX(instruments, driveTrain, (team == Team.RED ? -135 : 135)));
        registerController(new Controller() {
            @Override
            public boolean tick() {
                driveTrain.drive((team == Team.RED ? 0.2f : 0.2f), (team == Team.RED ? 0.2f : 0.2f));
                return true;
            }
        });
        registerController(new Stall(1250));
        registerController(new Controller() {
            @Override
            public boolean tick() {
                driveTrain.stop();
                return true;
            }
        });
    }
    public abstract void setTeam();
}
