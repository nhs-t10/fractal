package org.firstinspires.ftc.teamcode.neurons;

import org.firstinspires.ftc.teamcode.debug.Logger;

import java.util.ArrayList;

/**
 * Created by nhs on 10/20/16.
 */

public class AngleTurning extends PID {
    private double destination; //178
    public AngleTurning (double dest) {
        destination = dest;
        Kp = 3.0;
        Kd = 0.5;
        Ki = 0.3;
    }
    public ArrayList<Float> getDrivePowers(double currentAngle) {
        ArrayList<Float> powers = new ArrayList<Float>();
        float power = convertPower(getPower(getError(currentAngle)));
        Logger.logLine("Angle: " + currentAngle + 180);
        Logger.logLine("Error: "+ getError(currentAngle));
        Logger.logLine("Power: " + power);
        powers.add(-0.5f - power);
        powers.add(-0.5f + power);
        return powers;
    }
    public ArrayList<Float> getPivotPowers(double currentAngle) {
        ArrayList<Float> powers = new ArrayList<Float>();
        float power = convertPower(getPower(getError(currentAngle)));
        Logger.logLine("Angle: " + currentAngle + 180);
        Logger.logLine("Error: "+ getError(currentAngle));
        Logger.logLine("Power: " + power);
        powers.add(power);
        powers.add(-power);
        return powers;
    }
    public float convertPower (double p) {
//        if (p > .08) {
            return (float) p / 180f;
//        }
//        return 0;
    }
    public double getError(double currentAngle) { //-179
        //357, 0
        double a = (destination - currentAngle);
        double b = (360 - Math.abs(a));
        if (a > 0) {
            if (Math.abs(a) > Math.abs(b)) {
                return -b;
            }
            return a;
        }
        else {
            if (Math.abs(a) > Math.abs(b)) {
                return b;
            }
            return a;
        }
    }
}
