package org.firstinspires.ftc.teamcode.controllers;

import org.firstinspires.ftc.teamcode.organs.Instruments;

/**
 * Created by Jacob on 3/4/2017.
 */

public class InstrumentControl implements Controller {
    private boolean start;
    private Instruments instruments;

    public InstrumentControl(Instruments i, boolean s) {
        this.start = s;
        instruments = i;
    }

    @Override
    public boolean tick() {
        if(start) {
            instruments.start();
        } else {
            instruments.kill();
        }
        return true;
    }
}
