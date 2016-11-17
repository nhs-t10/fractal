package org.firstinspires.ftc.teamcode.neurons;

import org.firstinspires.ftc.teamcode.debug.Logger;

/**
 * Created by nhs on 11/16/16.
 */
public class LineDetection {
    public LineDetection() {}
    public boolean isAtLine(double leftLight, double rightLight) {
        Logger.logLine("left: " + leftLight + " right: " + rightLight);
        return (leftLight >= 0.08 && rightLight >= 0.08);
    }
}
