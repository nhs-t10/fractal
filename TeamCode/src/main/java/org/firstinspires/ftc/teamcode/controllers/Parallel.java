package org.firstinspires.ftc.teamcode.controllers;

import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.DebouncingButton;
import org.firstinspires.ftc.teamcode.statics.Controls;
import org.firstinspires.ftc.teamcode.statics.DriveSpeed;

/**
 * Created by max on 12/7/16.
 * Takes in a "sequence" of controllers. Is repeated, so state should reset for sub-controllers every time.
 */
public class Parallel implements Controller {
    private Controller c1;
    private Controller c2;
    public Parallel(Controller c1, Controller c2) {
        this.c1 = c1;
        this.c2 = c2;
    }
    public boolean tick() {
        return c1.tick() && c2.tick();
    }
}
