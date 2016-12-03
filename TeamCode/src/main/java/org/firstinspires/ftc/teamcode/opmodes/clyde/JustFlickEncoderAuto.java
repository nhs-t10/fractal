package org.firstinspires.ftc.teamcode.opmodes.clyde;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.autonomous.FlickOnce;
import org.firstinspires.ftc.teamcode.controllers.tests.Stall;
import org.firstinspires.ftc.teamcode.opmodes.T10Autonomous;
import org.firstinspires.ftc.teamcode.organs.Flicker;
import org.firstinspires.ftc.teamcode.organs.Spinner;

/**
 * Created by robotics on 11/14/16.
 */

/*This is a debug opmode for the time being so it wont follow all fractal conventions*/

@Autonomous(name="Just Flick Encoder", group="Autonomous")
public class JustFlickEncoderAuto extends T10Autonomous {
    @Override
    public void registration() {
        Flicker flicker = new Flicker(true, 1);
        registerController(new FlickOnce(flicker));
        registerController(new Controller() {
            @Override
            public boolean tick() {
                new Spinner(1).toggle(1);
                return true;
            }
        });
        registerController(new Stall(3000));
        registerController(new FlickOnce(flicker));
    }
}
