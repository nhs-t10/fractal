package org.firstinspires.ftc.teamcode.neurons;

/**
 * Created by nhs on 10/20/16.
 *
 * Calculates a power value based on error value. Automatically computes via proportion and derivative constants.
 */

public abstract class PID {
    public double Kp = 1;
    public double Kd = 0.5;
    public double Ki = 0.5;
    public double prevError = 1;
    public double getPower (double error) {
        double p = Kp * error;
        double d = Kd * (error - prevError);
        double i = Ki * (i + error);
        prevError = error;
        return p + d + i;
    }
}


