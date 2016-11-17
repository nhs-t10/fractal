package org.firstinspires.ftc.teamcode.neurons;

import org.firstinspires.ftc.teamcode.debug.Logger;

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
    public double integral = 0.0;
    public double getPower (double error) {
       if ( (.5 > Math.abs(error)) && (.2 > Math.abs((prevError - error)))) {
           Logger.logLine("derivative" + (prevError - error));
           integral = Ki * (integral + error);
           prevError = error;
           return 0;
       }
        double p = Kp * error;
        double d = Kd * (error - prevError);
        integral = Ki * (integral + error);
        prevError = error;
        return p + d + integral;
    }
}


