package org.firstinspires.ftc.teamcode.opmodes.bonnie;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.Sequencer;
import org.firstinspires.ftc.teamcode.controllers.autonomous.ApproachBeacon;
import org.firstinspires.ftc.teamcode.controllers.autonomous.DriftToLine;
import org.firstinspires.ftc.teamcode.controllers.autonomous.TouchFlick;
import org.firstinspires.ftc.teamcode.controllers.teleop.AlignToNearest;
import org.firstinspires.ftc.teamcode.controllers.teleop.ButtonPusher;
import org.firstinspires.ftc.teamcode.controllers.teleop.BonnieCollection;
import org.firstinspires.ftc.teamcode.controllers.teleop.OnButtonPress;
import org.firstinspires.ftc.teamcode.controllers.teleop.OneStickMecanum;
import org.firstinspires.ftc.teamcode.controllers.tests.Stall;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.opmodes.T10Opmode;
import org.firstinspires.ftc.teamcode.organs.Flicker;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.Pusher;
import org.firstinspires.ftc.teamcode.organs.Spinner;
import org.firstinspires.ftc.teamcode.organs.Stopper;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.statics.Controls;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TTouch;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by max on 10/19/16.
 */
@TeleOp(name="BonnieOp", group="Bonnie")
public class Bonnie extends T10Opmode {
    private MecanumDrivetrain drivetrain;
    private Flicker flicker;
    private Spinner spinner;
    private Spinner liftSpinner;
    private Pusher pusher;
    private Instruments instruments;

    private ArrayList<Controller> controllers = new ArrayList<Controller>();
    public void run() {
        Logger.logLine("Chassis 1 initialized.");
        drivetrain = new MecanumDrivetrain();
        flicker = new Flicker(false, -1);
        final Stopper stopper = new Stopper();
        spinner = new Spinner(-1);
        instruments = new Instruments();
        instruments.start();
        liftSpinner = new Spinner(Hardware.LiftSpinner, 1);
        pusher = new Pusher();

        Controller[] autoPressRight = {
                new OnButtonPress(Controls.AutoPressRight),
                new AlignToNearest(drivetrain, instruments),
                new DriftToLine(instruments, drivetrain, 0.12f),
                new AlignToNearest(drivetrain, instruments),
                new ApproachBeacon(drivetrain, instruments, pusher)
        };
        Controller[] autoPressLeft = {
                new OnButtonPress(Controls.AutoPressLeft),
                new AlignToNearest(drivetrain, instruments), //1.3, 2.5
                new DriftToLine(instruments, drivetrain, -0.12f),
                new AlignToNearest(drivetrain, instruments),
                new ApproachBeacon(drivetrain, instruments, pusher)
        };
        Controller[] autoAlignNearest = {
                new OnButtonPress(Controls.AutoAlign),
                new AlignToNearest(drivetrain, instruments)
        };
        Controller[] stopperFlip = {
                new OnButtonPress(Controls.StopperMacro),
                new Controller() {
                    @Override
                    public boolean tick() {
                        stopper.open();
                        return true;
                    }
                },
                new Stall(500),
                new Controller() {
                    @Override
                    public boolean tick() {
                        stopper.close();
                        return true;
                    }
                }
        };
        Controller[] autoBallScore = {
                new OnButtonPress(Controls.BallMacro),
                new Controller() {
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
                },
                new Stall(500),
                new Controller() {
                    @Override
                    public boolean tick() {
                        stopper.close();
                        return true;
                    }
                },
                new Stall(100),
                new TouchFlick(flicker, 600)
        };
        controllers.add(new Sequencer(autoPressRight, true));
        controllers.add(new Sequencer(autoPressLeft, true));
        controllers.add(new Sequencer(stopperFlip, true));
        controllers.add(new Sequencer(autoAlignNearest, true));
        controllers.add(new Sequencer(autoBallScore, true));
        controllers.add(new OneStickMecanum(drivetrain));
        controllers.add(new BonnieCollection(flicker, stopper, new ArrayList<Spinner>(Arrays.asList(spinner, liftSpinner))));
        controllers.add(new ButtonPusher(pusher));
    }
    public void tick() {
        for(int i=0; i<controllers.size(); i++) {
            controllers.get(i).tick();
        }
    }
}