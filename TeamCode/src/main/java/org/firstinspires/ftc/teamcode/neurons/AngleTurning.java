package org.firstinspires.ftc.teamcode.neurons;

import org.firstinspires.ftc.teamcode.debug.Logger;

import java.util.ArrayList;

/**
 * Created by nhs on 10/20/16.
 */

public class AngleTurning extends PID {
    private double destination; //178h
    private boolean setKi = true;
    private double prevPower = 0;
    private final float minPower = 0.13f;
    public AngleTurning (double dest) {
        destination = dest;
        Kp = 2.8;
        Ki = 0.7;
        Kd = 0.0;
    }
    @Deprecated
    public ArrayList<Float> getDrivePowers(double currentAngle){
        return getDrivePowers(currentAngle, -0.5f);
    }
    public ArrayList<Float> getDrivePowers(double currentAngle, float speed) {
        ArrayList<Float> powers = new ArrayList<Float>();
        float power = convertPower(getPower(getError(currentAngle), false));
        Logger.logLine("Angle: " + currentAngle);
        Logger.logLine("Error: "+ getError(currentAngle));
        Logger.logLine("Power: " + power);
        powers.add(speed + power);
        powers.add(speed - power);
        return powers;
    }
    public ArrayList<Float> getPivotPowers(double currentAngle) {
        ArrayList<Float> powers = new ArrayList<Float>();
        float power = convertPower(getPower(getError(currentAngle), false));
        Logger.logLine("OriginalPower: " + power);
        if (Math.abs(power) < minPower && power != 0) {power = Math.signum(power) * minPower;}
        Logger.logLine("Angle: " + currentAngle);
        Logger.logLine("Error: "+ getError(currentAngle));
        Logger.logLine("Power: " + power);
        powers.add(power);
        powers.add(-power);
        return powers;
    }
    public ArrayList<Float> getTuningPivotPowers(double currentAngle, double porportional, double integral, double derivative) {
        Kp = porportional;
        Ki = integral;
        Kd = derivative;
        Logger.logLine("Kp: " + Kp);
        Logger.logLine("Ki: " + Ki);
        Logger.logLine("Kd: " + Kd);
        ArrayList<Float> powers = new ArrayList<Float>();
        float power = convertPower(getPower(getError(currentAngle), false));
        Logger.logLine("Angle: " + currentAngle + 180);
        Logger.logLine("Error: "+ getError(currentAngle));
        Logger.logLine("Power: " + power);
        prevPower = power;
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
