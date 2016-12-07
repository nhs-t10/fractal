package org.firstinspires.ftc.teamcode.controllers.teleop;


import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.autonomous.FlickOnce;
import org.firstinspires.ftc.teamcode.controllers.tests.Stall;
import org.firstinspires.ftc.teamcode.organs.Flicker;
import org.firstinspires.ftc.teamcode.organs.Stopper;
import org.firstinspires.ftc.teamcode.statics.ControlParser;

import java.util.ArrayList;

/**
 * Created by robotics on 12/1/16.
 */
public class BallMacro implements Controller {
    private ArrayList<Controller> subcontroller;
    private int index = 0;
    private boolean start = false;

    public BallMacro(Flicker flicker) {
        subcontroller = new ArrayList<Controller>();
        subcontroller.add(new FlickOnce(flicker));
        //because im lazy
        subcontroller.add(new Controller() {
            @Override
            public boolean tick() {
                new Stopper().toggle();
                return true;
            }
        });

        subcontroller.add(new Stall(3000));
        subcontroller.add(new FlickOnce(flicker));
    }

    @Override
    public boolean tick() {
        if(ControlParser.button("DL1")) {
            start = true;
        }

        if(start && subcontroller.get(index).tick()) {
            index++;
            if(index == subcontroller.size()) {
                index = 0;
                start = false;
            }
        }

        return false;
    }
}