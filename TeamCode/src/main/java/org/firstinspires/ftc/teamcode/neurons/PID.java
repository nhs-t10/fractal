package org.firstinspires.ftc.teamcode.neurons;

/**
 * Created by nhs on 10/20/16.
 */

public abstract class PID {
    public double Kp = 1;
    public double Kd = 0.5;
    public double prevError = 1;
    public double getPower (double error) {
        double p = Kp * error;
        double d = Kd * (error - prevError);
        prevError = error;
        return p + d;
    }
}
