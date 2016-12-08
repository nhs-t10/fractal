package org.firstinspires.ftc.teamcode.controllers.teleop;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.neurons.DebouncingButton;
import org.firstinspires.ftc.teamcode.organs.Flicker;
import org.firstinspires.ftc.teamcode.organs.Spinner;
import org.firstinspires.ftc.teamcode.organs.Stopper;
import org.firstinspires.ftc.teamcode.statics.ControlParser;
import org.firstinspires.ftc.teamcode.statics.Controls;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by robotics on 5/31/16.
 */
public class Collection implements Controller {
    private Flicker flicker;
    private Spinner spinner;
    private DebouncingButton stopperBtn = new DebouncingButton(Controls.Stopper);
    private DebouncingButton spinnerInBtn = new DebouncingButton(Controls.SpinnerIn);
    private DebouncingButton spinnerOutBtn = new DebouncingButton(Controls.SpinnerOut);
    private DebouncingButton liftBtn = new DebouncingButton(Controls.BallLift);

    public Collection(Flicker f, Spinner sp) {
        flicker = f;
        spinner = sp;
    }
    
    public boolean tick() {
        if(ControlParser.button(Controls.Flicker)) flicker.engage();
        else flicker.stop();

        if(spinnerInBtn.getToggle()) {
                spinner.toggle(1);
        } else if(spinnerOutBtn.getToggle()) {
                spinner.toggle(-1);
        }

        return false;
    }
}
