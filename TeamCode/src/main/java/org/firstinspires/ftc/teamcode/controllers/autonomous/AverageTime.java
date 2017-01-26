package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.Time;

/**
 * Created by Jacob on 1/26/2017.
 */

public class AverageTime implements Controller {
    private Time.Stopwatch sw;
    private boolean started = false;
    private int count = 0;
    private double past = 0;
    public AverageTime(){
        sw = new Time.Stopwatch();
    }
    public boolean tick(){
        if (!started){
            started = true;
            sw.start();
        }
        past += sw.timeElapsed();
        sw.reset();
        count++;
        Logger.logLine("Average Time" + past/count);
        if (count >= 1000000){
            return true;
        }
        return false;
    }
}
