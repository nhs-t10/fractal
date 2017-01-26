package org.firstinspires.ftc.teamcode.organs;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.lib.Lock;
import org.firstinspires.ftc.teamcode.lib.Sleep;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TMotor;

/**
 * Created by robotics on 9/22/16.
 */
public class Spinner implements Component {
    private TMotor spinner;
    private Lock lock = new Lock();
    private boolean on = false;
    private int direction = -1;

    public Spinner(int d) {
        this(Hardware.Spinner, d);
    }

    public Spinner(String name, int d) {
        spinner = new TMotor(name);
        direction = d;
    }

    public void toggle(int dir) {
        spinner.move((on ? 0 : direction * dir));
        on = !on;
    }

    public boolean isOn() {
        return on;
    }

    public void lock(boolean status) {
        lock(status, lock.DEFAULT_PASS);
    }

    public void lock(boolean status, String key) {
        if(status) lock.lock(key);
        else lock.ulock(key);
    }

    public boolean inUse() {
        return lock.isLocked();
    }

    public boolean usesKey(String key) {
        return lock.usesKey(key);
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
