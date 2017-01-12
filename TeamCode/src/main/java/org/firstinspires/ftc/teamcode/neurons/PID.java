package org.firstinspires.ftc.teamcode.neurons;

import org.firstinspires.ftc.teamcode.debug.Logger;

/**
 * Created by nhs on 10/20/16.
 *
 * Calculates a power value based on error value. Automatically computes via proportion and derivative constants.
 */

public abstract class PID {
    protected double Kp = 1;
    protected double Kd = 0.5;
    protected double Ki = 0.0;
    protected double prevError = 1;
    private double pastError = 0;
    private Time.Stopwatch sw;
    private boolean startedCount = false;
    private boolean sign = true;
    private boolean count = false;
    public double getPower (double error, boolean lightSensor) {
        if(!startedCount) {
            sw = new Time.Stopwatch();
            sw.start();
            startedCount = true;
        }
        if ( (.5 > Math.abs(error)) && (.2 > Math.abs((prevError - error)))) {
           Logger.logLine("derivative " + (error - prevError));
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
        Logger.logLine("prevError: " + (error - prevError) + ", " + error + ", " + prevError + ", count: " + count);
        Logger.logLine("derivative: " + d);
        Logger.logLine("Time Elapsed: " + sw.timeElapsed());
        if (count != true) {
            prevError = error;
        }
        count = !count;
        return p + d + i;
    }
}


