 package org.firstinspires.ftc.teamcode.neurons;

import org.firstinspires.ftc.teamcode.debug.Logger;

/**
 * Created by nhs on 10/20/16.
 *
 * Calculates a power value based on error value. Automatically computes via proportion and derivative constants.
 */

public abstract class PID {
    protected double Kp;
    protected double Kd;
    protected double Ki;
    protected double prevError = 0;
    private double pastError = 0;
    private Time.Stopwatch sw;
    private boolean startedCount = false;
    private boolean sign = true;
    private boolean count = false;
    private float time;
    private float cumTime;
    public double getPower (double error, boolean lightSensor) {
        if(!startedCount) {
            sw = new Time.Stopwatch();
            sw.start();
            startedCount = true;
            prevError = error;
        }
        time = sw.timeElapsed();
        cumTime = cumTime + time;
        double p = Kp * error;
        if (time == 0){
            time = 1;
        }
        double d = -Math.signum(error) * Math.abs(Kd * ((error - prevError) / time));
        if (error > 0 == !sign){
            sign = !sign;
            pastError = 0;
        }
        pastError = pastError + error * time / 1000;
        sw.reset();
        double i = Ki * pastError;
//        Logger.logLine("prevError: " + (error - prevError) + ", " + error + ", " + prevError + ", count: " + count);
//        Logger.logLine("derivative: " + d);
//        Logger.logLine("Time Elapsed: " + time);
//        Logger.logFile("Error", "Error: " + error + ", Time: " + stopwatch.timeElapsed() + ", Power: " + ((p + d + i) / 180));
        Logger.logFile("Error", error + ", " + cumTime + ", " + ((p + d + i) / 180) + "," + d);
        if (count != true) {
            prevError = error;
        }
        count = !count;

        if (((1.5 > error && error > 0 && error < prevError) || (-1.5 < error && error < 0 && error > prevError)) && Math.abs(d) < .05)
//                && (.2 > Math.abs((prevError - error)))
        {
//           Logger.logLine("derivative " + (error - prevError));
            return 0;
        }
        return p + d + i;
    }
}


