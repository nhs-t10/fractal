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
    public boolean tick() {
        if (ControlParser.button(Controls.Flicker)) flicker.toggle();
        if (ControlParser.button(Controls.Spinner)) spinner.toggle();
        return false;
    }
}
