package org.firstinspires.ftc.teamcode.controllers.teleop;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.neurons.HumanDriving;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.statics.ControlParser;
import org.firstinspires.ftc.teamcode.statics.Controls;

import java.lang.reflect.Array;
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
        ArrayList<Float> leftJoy = ControlParser.range(Controls.JoyDrive); //left joystick (roll and pitch)
        ArrayList<Float> rightJoy = ControlParser.range(Controls.JoySecondary); //right joystick (yaw)
        rightJoy.set(0, -rightJoy.get(0)); //make yaw negative

        // Remap vLeft and hRight joystick into a "virtual" single joystick
        ArrayList<Float> vals = new ArrayList<Float>();
        vals.add(rightJoy.get(0));
        vals.add(leftJoy.get(1));
        ArrayList<Float> powers = HumanDriving.joyToPowers(vals);

        // Do the same for hLeft joystick
        ArrayList<Float> vals2 = new ArrayList<Float>();
        vals2.add(leftJoy.get(0));
        vals2.add(0f);
        ArrayList<Float> sidePowers = HumanDriving.joyToPowers(vals2);

        if (Math.abs(leftJoy.get(0)) > 0.1) {
            drivetrain.driveSideways(sidePowers.get(0));
        } else {
            drivetrain.drive(powers.get(0), powers.get(1));
        }

        return false;
    }
}