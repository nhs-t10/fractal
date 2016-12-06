package org.firstinspires.ftc.teamcode.controllers.tests;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.DebouncingButton;
import org.firstinspires.ftc.teamcode.statics.ControlParser;
import org.firstinspires.ftc.teamcode.statics.Controls;

/**
 * Created by robotics on 11/18/16.
 */
public class ChangeableVariable implements Controller {
    private DebouncingButton set;
    private DebouncingButton changeUp;
    private DebouncingButton changeDown;

    private double data;
    private double inc;

    private boolean verbose;

    public static class Options {
        public String setCtrl = "A1";
        public String upCtrl = "Y1";
        public String downCtrl = "X1";
        public boolean verbose = false;
    }

    public ChangeableVariable(double var, double inc) {
        this(var, inc, new Options());
    }

    public ChangeableVariable(double var, double inc, Options opt) {
        data = var;

        set = new DebouncingButton(opt.setCtrl);
        changeUp = new DebouncingButton(opt.upCtrl);
        changeDown = new DebouncingButton(opt.downCtrl);
        verbose = opt.verbose;
    }

    public double getVariable() {
        return data;
    }

    @Override
    public boolean tick() {
        if(set.getToggle()) {
            return true;
        }

        if(changeUp.getToggle()) {
            data += inc;
        } else if(changeDown.getToggle()) {
            data -= inc;
        }

        if(verbose) {
            Logger.logLine(data);
        }

        return false;
    }
}
