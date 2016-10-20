package org.firstinspires.ftc.teamcode.neurons;

import java.util.ArrayList;

/**
 * Created by nhs on 10/20/16.
 */

public class AngleTurning extends PID {
    private double destination; //178
    private double initialAngle; // -178
    public AngleTurning (double dest, double initial) {
        destination = dest;
        initialAngle = initial;
    }
    public ArrayList<Float> getPowers(double currentAngle) {
        ArrayList<Float> powers = new ArrayList<Float>();
        float power = convertPower(getPower(getError(currentAngle)));
        powers.add(power);
        powers.add(-power);
        return powers;
    }
    public float convertPower (double p) {
        return (float) p / 180f;
    }
    public double getError(double currentAngle) { //-179
        //357, 0
        double a = (destination - currentAngle);
        double b = 180 - Math.abs(a);
        return (destination - Math.abs((initialAngle - currentAngle)));
    }
}
