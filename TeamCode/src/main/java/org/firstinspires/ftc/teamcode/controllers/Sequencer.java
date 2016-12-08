package org.firstinspires.ftc.teamcode.controllers;

import org.firstinspires.ftc.teamcode.neurons.DebouncingButton;
import org.firstinspires.ftc.teamcode.statics.Controls;
import org.firstinspires.ftc.teamcode.statics.DriveSpeed;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by max on 12/7/16.
 * Takes in a "sequence" of controllers. Is repeated, so state should reset for sub-controllers every time.
 */
public class Sequencer implements Controller {
    private Controller[] queue = {};
    private DebouncingButton cancel;
    private boolean terminatable;
    private int index = 0;
    public Sequencer(Controller[] ctrls) {
        this(ctrls, false);
    }
    public Sequencer(Controller[] ctrls, boolean term) {
        queue = ctrls;
        terminatable = term;
        cancel = new DebouncingButton(Controls.Terminate);
    }
    public boolean tick() {
        if (terminatable) {
            if (cancel.getToggle()) {
                index = 0;
                DriveSpeed.macroBusy = false;
                return true;
            }
        }
        boolean ticked = queue[index].tick();
        if(ticked) {
            if (index == queue.length - 1) {
                index = 0;
                DriveSpeed.macroBusy = false;
                return true;
            }
            DriveSpeed.macroBusy = true;
            index++;
            return false;
        }
        return false;
    }
}
