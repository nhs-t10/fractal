package org.firstinspires.ftc.teamcode.neurons;

import org.firstinspires.ftc.teamcode.debug.Logger;

/**
 * Created by nhs on 11/16/16.
 */
public class LineDetection {
    public LineDetection() {}
    public boolean isAtLine(double leftLight, double rightLight) {
        Logger.logLine("left: " + leftLight + " right: " + rightLight + " " + (leftLight >= 0.1 && rightLight >= 0.1 ? "true" : "false"));
        return (leftLight >= 0.1 || rightLight >= 0.1);
    }
}
