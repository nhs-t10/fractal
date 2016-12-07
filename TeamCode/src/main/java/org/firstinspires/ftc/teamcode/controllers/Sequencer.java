package org.firstinspires.ftc.teamcode.controllers;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by max on 12/7/16.
 * Takes in a "sequence" of controllers. Is repeated, so state should reset for sub-controllers every time.
 */
public class Sequencer implements Controller {
    private Controller[] queue = {};
    private int index = 0;
    public Sequencer(Controller[] ctrls) {
        queue = ctrls;
    }
    public boolean tick() {
        boolean ticked = queue[index].tick();
        if(ticked) {
            if (index == queue.length - 1) {
                index = 0;
                return true;
            }
            return false;
        }
        return false;
    }
}
