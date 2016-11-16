package org.firstinspires.ftc.teamcode.organs;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.lib.Sleep;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TMotor;

/**
 * Created by robotics on 9/22/16.
 */
public class Spinner implements Component {
    private TMotor spinner;
    private boolean on = false;
    public Spinner() {
        spinner = new TMotor(Hardware.Spinner);
    }

    public void toggle(int dir) {
        spinner.move((on ? 0 : dir * 2.0f));
        on = !on;
    }

    @Override
    public String getName() {
        return "Ball Collector (Spinner)";
    }

    @Override
    public boolean test() {
        toggle(1);
        Sleep.secs(3);
        toggle(1);
        Sleep.secs(3);
        toggle(-1);
        Sleep.secs(3);
        toggle(-1);
        return false;
    }
}
