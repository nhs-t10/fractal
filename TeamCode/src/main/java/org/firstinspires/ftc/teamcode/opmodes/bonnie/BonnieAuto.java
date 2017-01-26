package org.firstinspires.ftc.teamcode.opmodes.bonnie;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.Team;
import org.firstinspires.ftc.teamcode.controllers.autonomous.DriftToLine;
import org.firstinspires.ftc.teamcode.controllers.autonomous.DriveFromWall;
import org.firstinspires.ftc.teamcode.controllers.autonomous.DriveToLine;
import org.firstinspires.ftc.teamcode.controllers.autonomous.PressBeacon;
import org.firstinspires.ftc.teamcode.controllers.autonomous.TouchFlick;
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
import org.firstinspires.ftc.teamcode.tissues.TTouch;

/**
 * Created by nhs on 11/15/16.
 */
public abstract class BonnieAuto extends T10Autonomous {
    private TCamera camera;
    public Team team;
    private int blueAngle = -60;
    private int redAngle = 47;
    @Override
    public void registration() {
        setTeam();
        camera = new TCamera();
        final MecanumDrivetrain driveTrain = new MecanumDrivetrain();
        final Instruments instruments = new Instruments();
        instruments.start();
        Pusher pusher = new Pusher();
        Flicker flicker = new Flicker(false, -1);
        final Stopper stopper = new Stopper();
        final Spinner spinner = new Spinner(-1);
        final Spinner liftSpinner = new Spinner(Hardware.LiftSpinner, 1);
        //Advance from the wall and flick
        registerController(new DriveFromWall(instruments, driveTrain, (team == Team.RED ? 0.24 : 0.24)));
        registerController(new TurnX(instruments, driveTrain, (team == Team.RED ? 90 : 90)));

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
        //DRIVE TO THE line
        if (team == Team.RED) {
//            registerController(new TurnX(instruments, dri));
            registerController(new TurnX(instruments, driveTrain, (team == Team.RED ? 90 : 90)));
            registerController(new DriveFromWall(instruments, driveTrain, -0.24));
        }
        registerController(new TurnX(instruments, driveTrain, team == Team.RED ? redAngle : blueAngle));
        registerController(new DriveToLine(instruments, driveTrain, team == Team.RED ? redAngle : blueAngle));
        //Go for 1st beacon
        registerController(new TurnX(instruments, driveTrain, (team == Team.RED ? 90 : -90)));

        registerController(new Controller() {
            @Override
            public boolean tick() {
                driveTrain.driveSideways((team == Team.RED ? -0.2f : 0.2f));
                return true;
            }
        });
        registerController(new Stall(250));
        registerController(new Controller() {
            @Override
            public boolean tick() {
                driveTrain.stop();
                return true;
            }
        });
        registerController(new TurnX(instruments, driveTrain, (team == Team.RED ? 90 : -90)));
        registerController(new DriftToLine(instruments, driveTrain, (team == Team.RED ? 0.1f : -0.1f), true));
        registerController(new TurnX(instruments, driveTrain, (team == Team.RED ? 90 : -90)));
        registerController(new PressBeacon(team, instruments, driveTrain, pusher, camera, true));
 //        registerController(new DriveFromWall(instruments, driveTrain, 0.12));
//        //Shift backwards, sideways
        registerController(new Controller() {
            @Override
            public boolean tick() {
                if (instruments.IRdistance <= 1.1) {
                    driveTrain.stop();
                    return true;
                }
                driveTrain.goForward(0.15f);
                return false;
            }
        });
        registerController(new Controller() {
            @Override
            public boolean tick() {
                driveTrain.driveSideways((team == Team.RED ? 0.2f : -0.2f));
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
        registerController(new TurnX(instruments, driveTrain, (team == Team.RED ? 90 : -90)));
        registerController(new DriftToLine(instruments, driveTrain, team, false));
//        registerController(new AlignToNearest(driveTrain, instruments));
//        registerController(new TurnX(instruments, driveTrain, 0));
//        registerController(new DriveToLine(instruments, driveTrain, (team == Team.RED ? 2 : -2)));
//        registerController(new TurnX(instruments, driveTrain, (team == Team.RED ? 90 : -90)));
//        registerController(new DriftToLine(instruments, driveTrain, team); 0.22
        registerController(new TurnX(instruments, driveTrain, (team == Team.RED ? 90 : -90)));
        registerController(new DriftToLine(instruments, driveTrain, (team == Team.RED ? -0.1f : 0.12f), true));
//        registerController(new TurnX(instruments, driveTrain, (team == Team.RED ? 90 : -90)));
        registerController(new PressBeacon(team, instruments, driveTrain, pusher, camera, true));
        registerController(new DriveFromWall(instruments, driveTrain, 0.08));
        //LAST STEP: Align perfectly to a wall. Necessary for driver controlled period so we have a calibrated IMU!!
        registerController(new AlignToNearest(driveTrain, instruments));
//        registerController(new TurnX(instruments, driveTrain, (team == Team.RED ? -135 : 135)));
//        registerController(new HitBall(instruments, driveTrain, team));

    }
    public abstract void setTeam();
    @Override
    public void stop() {
        camera.stop();
    }
}
