package org.firstinspires.ftc.teamcode.lib;

/**
 * Created by robotics on 1/24/17.
 */
public interface Lock {
    void lock(boolean status);
    boolean inUse();
}
