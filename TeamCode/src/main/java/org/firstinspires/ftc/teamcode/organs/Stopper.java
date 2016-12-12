package org.firstinspires.ftc.teamcode.organs;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TServo;

/**
 * Created by robotics on 11/29/16.
 */
public class Stopper implements Component {
    private TServo stopper;
    private boolean open;

    public Stopper() {
        stopper = new TServo(Hardware.ServoStop);
        open = false;
        close();
    }


    public void toggle() {
        if(open) {
            close();
        } else {
            open();
        }
        open = !open;
    }

    public void open() {
        stopper.moveTo(0.7);
    }

    public void close() {
        stopper.moveTo(0.1);
    }

    public void push() {
        stopper.moveTo(0.0);
    }

    @Override
    public String getName() {
        return "Stopper";
    }

    @Override
    public boolean test() {
        return false;
    }
}
