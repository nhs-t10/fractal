package org.firstinspires.ftc.teamcode.controllers.teleop;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.organs.JonFlicker;
import org.firstinspires.ftc.teamcode.statics.ControlParser;

/**
 * Created by robotics on 9/22/16.
 */
public class FlickerControl implements Controller {
    JonFlicker flicker = new JonFlicker();

    @Override
    public boolean tick() {
        boolean pressed = ControlParser.button("A1");

        if(pressed) {
            flicker.move(-1.0f);
        } else {
            flicker.move(0.0f);
        }

        return false;
    }
}
