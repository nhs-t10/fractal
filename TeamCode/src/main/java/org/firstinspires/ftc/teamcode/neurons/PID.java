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
    private double pastError = 0;
    private Time.Stopwatch sw;
    private boolean startedCount = false;
    private boolean sign = true;
    public double getPower (double error) {
        if(!startedCount) {
            sw = new Time.Stopwatch();
            sw.start();
            startedCount = true;
        }
       if ( (.5 > Math.abs(error)) && (.2 > Math.abs((prevError - error)))) {
           Logger.logLine("derivative " + (prevError - error));
           prevError = error;
           return 0;
       }

        double p = Kp * error;
        double d = Kd * (error - prevError);
        if (error > 0 == !sign){
            sign = !sign;
            pastError = 0;
        }
        pastError = pastError + error * sw.timeElapsed() / 1000;
        sw.reset();
        double i = Ki * pastError;
        Logger.logLine("pastError: " + pastError);
        Logger.logLine("integral " +  i);
        prevError = error;
        return p + d + i;
    }
}


