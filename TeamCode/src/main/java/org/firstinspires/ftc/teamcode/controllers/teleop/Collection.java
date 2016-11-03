package org.firstinspires.ftc.teamcode.controllers.teleop;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.neurons.DebouncingButton;
import org.firstinspires.ftc.teamcode.neurons.HumanDriving;
import org.firstinspires.ftc.teamcode.organs.Flicker;
import org.firstinspires.ftc.teamcode.organs.Spinner;
import org.firstinspires.ftc.teamcode.statics.ControlParser;
import org.firstinspires.ftc.teamcode.statics.Controls;

import java.util.ArrayList;

/**
 * Created by robotics on 5/31/16.
 */
public class Collection implements Controller {
    private Flicker flicker;
    private Spinner spinner;
    private boolean flickerBtn;
    private DebouncingButton spinnerBtn = new DebouncingButton(Controls.Spinner);
    public Collection(Flicker f, Spinner s) {
        flicker = f;
        spinner = s;
    }

    public boolean tick() {
        flickerBtn = ControlParser.button(Controls.Flicker);

        if(flickerBtn) {
            flicker.flick();
        }

        if(spinnerBtn.getToggle()) {
            spinner.toggle();
        }
        return false;
    }
}
