package com.qualcomm.ftcrobotcontroller.organs;

import com.qualcomm.ftcrobotcontroller.statics.Hardware;
import com.qualcomm.ftcrobotcontroller.tissues.TColor;
import com.qualcomm.ftcrobotcontroller.tissues.TIMU;
import com.qualcomm.ftcrobotcontroller.tissues.TUltra;

/**
 * Created by max on 4/18/16.
 *
 * Represents the sensor array on the robot. Acts as an asynchronous state container for sensor values to prevent over-polling.
 * Could also manipulate motor mounted sensors.
 */
public class Instruments {
    private static TColor colorsensor;
    private static TUltra ultrasensor;
    private static TIMU imusensor;
    private static Boolean inited = false;

    public static class color {
        public static int red, green, blue;
    }
    public static double distance;
    public static double yaw;
    
    private static void tick() {
        color.red = colorsensor.red();
        color.green = colorsensor.green();
        color.blue = colorsensor.blue();
        distance = ultrasensor.distance();
        yaw = imusensor.getYaw();
    }
    private static void beginCycle() {
        tick();
    }
    public static void init() {
        if(!inited) {
            colorsensor = new TColor(Hardware.Color);
            ultrasensor = new TUltra(Hardware.Ultra);
            imusensor = new TIMU(Hardware.IMU);
            inited = true;
            beginCycle();
        }
    }
}
