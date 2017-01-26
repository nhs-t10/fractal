package org.firstinspires.ftc.teamcode.controllers.teleop;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.neurons.HumanDriving;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.statics.ControlParser;
import org.firstinspires.ftc.teamcode.statics.Controls;
import org.firstinspires.ftc.teamcode.statics.DriveSpeed;

import java.util.ArrayList;

/**
 * Created by will on 9/20/16.
 */
public class OneStickMecanum implements Controller {
    private MecanumDrivetrain drivetrain;

    public OneStickMecanum() {
        drivetrain = new MecanumDrivetrain();
    }

    public OneStickMecanum(MecanumDrivetrain dt) {
        drivetrain = dt;
    }

    public boolean tick() {
        ArrayList<Float> joyValues = ControlParser.range(Controls.JoyDrive);
        joyValues.set(0, -joyValues.get(0));
        ArrayList<Float> powers = HumanDriving.joyToPowers(joyValues);

        ArrayList<Float> joy2Values = ControlParser.range(Controls.JoySecondary);
        ArrayList<Float> sidePowers = HumanDriving.joyToPowers(joy2Values);

        if (Math.abs(sidePowers.get(0)) > 0.1) {
            drivetrain.driveSideways(-sidePowers.get(0));
        } else {
            if(!DriveSpeed.macroBusy) drivetrain.drive(powers.get(0), powers.get(1));
        }

        return false;
    }
}