package org.firstinspires.ftc.teamcode.controllers.teleop;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.organs.Flicker;
import org.firstinspires.ftc.teamcode.organs.Spinner;
import org.firstinspires.ftc.teamcode.statics.ControlParser;
import org.firstinspires.ftc.teamcode.statics.Controls;

/**
 * Created by robotics on 5/31/16.
 */
public class Collection implements Controller {
    private Flicker flicker;
    private Spinner spinner;
    public Collection(Flicker f, Spinner s) {
        flicker = f;
        spinner = s;
    }

    boolean flickDebounce = false;
    boolean spinDebounce = false;

    public boolean tick() {
        if(!flickDebounce && ControlParser.button((Controls.Flicker))) {
            flickDebounce = true;
            flicker.toggle();
        }
        else if (!ControlParser.button(Controls.Flicker)) {
            flickDebounce = false;
        }
        if(!spinDebounce && ControlParser.button((Controls.Spinner))) {
            spinDebounce = true;
            spinner.toggle();
        }
        else if (!ControlParser.button(Controls.Spinner)) {
            spinDebounce = false;
        }
        return false;
    }
}
