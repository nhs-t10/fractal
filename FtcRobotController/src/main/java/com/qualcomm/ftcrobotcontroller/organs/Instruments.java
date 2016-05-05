package com.qualcomm.ftcrobotcontroller.organs;

import com.qualcomm.ftcrobotcontroller.debug.Component;
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
public class Instruments extends Component {
    private TColor colorsensor;
    private TUltra ultrasensor;
    private TIMU imusensor;

    public String name = "Instruments";

    private class Color {
        public int red, green, blue;
    }
    public Color color = new Color();
    public double distance;
    public double yaw;
    //TODO: make a cycle
    private void tick() {
        color.red = colorsensor.red();
        color.green = colorsensor.green();
        color.blue = colorsensor.blue();
        distance = ultrasensor.distance();
        yaw = imusensor.getYaw();
    }
    private void beginCycle() {
        tick();
    }
    public Instruments() {
        colorsensor = new TColor(Hardware.Color);
        ultrasensor = new TUltra(Hardware.Ultra);
        imusensor = new TIMU(Hardware.IMU);
        beginCycle();
    }

    public Boolean test() {
        this.tick();
        return true;
    }
}
