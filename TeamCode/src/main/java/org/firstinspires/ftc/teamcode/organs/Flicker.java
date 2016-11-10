package org.firstinspires.ftc.teamcode.organs;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.lib.Sleep;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TEncoderMotor;
import org.firstinspires.ftc.teamcode.tissues.TMotor;

/**
 * Created by robotics on 9/22/16.
 */
public class Flicker implements Component {
    //private TEncoderMotor flicker;
    private TMotor flicker;
    private boolean on = false;
    public Flicker() {
        flicker = new TMotor(Hardware.Flicker);
    }

    public void toggle() {
        flicker.move(on ? 0 : 1f);
        on = !on;
    }

    public void flick() {
        Logger.logLine("Flicking");
        //flicker.rotate360(1);
        Logger.logLine("Flicked");
    }

    @Override
    public String getName() {
        return "Ball Flicker";
    }

    @Override
    public boolean test() {
        toggle();
        Sleep.secs(5);
        toggle();
        return false;
    }
}
