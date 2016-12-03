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
    public int direction = -1;

    public Spinner() {
        this(Hardware.Spinner);
    }

    public Spinner(String name) {
        spinner = new TMotor(name);
    }

    public void toggle(int dir) {
        spinner.move((on ? 0 : direction * dir));
        on = !on;
    }

    public boolean isOn() {
        return on;
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
