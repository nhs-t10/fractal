package org.firstinspires.ftc.teamcode.neurons;

import org.firstinspires.ftc.teamcode.debug.Logger;

import java.util.ArrayList;

/**
 * Created by max on 11/15/16.
 */
public class LineAlignment extends PID {
    public LineAlignment () {
        Kp = 0.5;
        Kd = 0.2;
        Ki = 0.3;
    }
    public ArrayList<Float> getPivotPowers(double leftLight, double rightLight) {
        ArrayList<Float> powers = new ArrayList<Float>();
        Logger.logLine("Left light: " + leftLight+ " Right light:" + rightLight);
        float power = convertPower(getPower(getError(leftLight, rightLight)));
        powers.add(power);
        powers.add(-power);
        return powers;
    }
    public float convertPower(double p) {
        return (float) p / 5f;
    }
    public double getError(double l, double r) {
        return l - r;
    }
}
