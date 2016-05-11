package com.qualcomm.ftcrobotcontroller.tissues;

import com.qualcomm.ftcrobotcontroller.debug.Component;
import com.qualcomm.ftcrobotcontroller.debug.Logger;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by max on 4/17/16.
 */
public class TColor implements Component {
    private ColorSensor colorsensor;

    public String name = "Color";

    private int offsetRed, offsetGreen, offsetBlue, offsetAlpha;
    private int threshold = 50;

    public enum Color {
        RED, BLUE, WHITE, NONE
    }

    public TColor(ColorSensor c) {
        colorsensor = c;
        this.calibrate();
    }

    /**
     * Sets i2c adress of the color sensor
     * @param newAddress address to be set.
     */
    public void setI2C(int newAddress) {
        colorsensor.setI2cAddress(newAddress);
    }

    /**
     * Gets the red of the color sensor
     * @return red value read by the color sensor
     */
    public int red() {
        return Math.abs(colorsensor.red() - offsetRed);
    }

    /**
     * Gets the green of the color sensor
     * @return green value read by the color sensor
     */
    public int green() {
        return Math.abs(colorsensor.green() - offsetGreen);
    }

    /**
     * Gets the blue of the color sensor
     * @return blue value read by the color sensor
     */
    public int blue() {
        return Math.abs(colorsensor.blue() - offsetBlue);
    }

    /**
     * Gets the alpha of the color sensor
     * @return alpha value read by the color sensor
     */
    public int alpha() {
        return Math.abs(colorsensor.alpha() - offsetAlpha);
    }

    /**
     * Sets the threshold of the color sensor.
     * @param t threshhold to be set
     */
    public void setThreshold(int t) {
        threshold = t;
    }

    /**
     * Calibrates the color sensor.
     */
    public void calibrate() {
        offsetRed = colorsensor.red();
        offsetGreen = colorsensor.green();
        offsetBlue = colorsensor.blue();
        offsetAlpha = colorsensor.alpha();
    }

    public Boolean test() {
        Logger.logLine(colorsensor.getConnectionInfo() + " r:" + this.red() + " g:" + this.green() + " b:" + this.blue());
        return true;
    }
}
