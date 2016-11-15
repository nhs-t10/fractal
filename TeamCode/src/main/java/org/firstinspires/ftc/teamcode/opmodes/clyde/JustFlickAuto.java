package org.firstinspires.ftc.teamcode.opmodes.clyde;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.controllers.autonomous.FlickOnce;
import org.firstinspires.ftc.teamcode.controllers.tests.StallForever;
import org.firstinspires.ftc.teamcode.opmodes.T10Autonomous;

/**
 * Created by robotics on 11/14/16.
 */

/*This is a debug opmode for the time being so it wont follow all fractal conventions*/

@Autonomous(name="Just Flick", group="Autonomous")
public class JustFlickAuto extends T10Autonomous {
    @Override
    public void registration() {
        registerController(new FlickOnce());
        registerController(new StallForever());
    }
}
