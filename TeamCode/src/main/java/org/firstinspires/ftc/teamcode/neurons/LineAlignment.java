package org.firstinspires.ftc.teamcode.neurons;

import org.firstinspires.ftc.teamcode.debug.Logger;

import java.util.ArrayList;

/**
 * Created by max on 11/15/16.
 */
public class LineAlignment extends PID {
    public LineAlignment () {
        Kp = 10f;
        Kd = 0.0;
        Ki = 0.7;
    }
    public ArrayList<Float> getDrivePowers(double leftLight, double rightLight) {
        ArrayList<Float> powers = new ArrayList<Float>();
        Logger.logLine("Left light: " + leftLight+ " Right light: " + rightLight);
        float power = convertPower(getPower(getError(leftLight, rightLight), true));
        Logger.logLine("Error: " + getError(leftLight, rightLight) + " Power: " + getPower(getError(leftLight, rightLight), true));
        powers.add(-0.5f + power);
        powers.add(-0.5f - power);
        return powers;
    }
    public float convertPower(double p) {
        return (float) p / 5f;
    }
    public double getError(double l, double r) {
        return (l - r);
    }
}
