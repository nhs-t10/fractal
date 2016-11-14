package org.firstinspires.ftc.teamcode.opmodes.clyde;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.controllers.tests.StallForever;
import org.firstinspires.ftc.teamcode.opmodes.T10Autonomous;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TEncoderMotor;

/**
 * Created by robotics on 11/14/16.
 */

/*This is a debug opmode for the time being so it wont follow all fractal conventions*/

@Autonomous(name="Just Flick", group="Autonomous")
public class JustFlickAuto extends T10Autonomous {
    TEncoderMotor fl;

    @Override
    public void registration() {
        fl = new TEncoderMotor(Hardware.Flicker);
        fl.setDirection(false);
        //fl.setPosition(0);
        fl.rotate360(1);
        registerController(new StallForever());
    }
}
