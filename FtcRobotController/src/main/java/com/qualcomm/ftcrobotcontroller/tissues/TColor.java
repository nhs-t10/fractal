package com.qualcomm.ftcrobotcontroller.tissues;

import com.qualcomm.ftcrobotcontroller.debug.Component;
import com.qualcomm.ftcrobotcontroller.debug.Logger;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by max on 4/17/16.
 */
public class TColor extends Component {
    private ColorSensor colorsensor;

    public String name = "Color";

    private int offsetRed, offsetGreen, offsetBlue, offsetAlpha;
    private int threshold = 50;

    private enum Color {
        RED, BLUE, WHITE, NONE
    }

    public TColor(ColorSensor c) {
        colorsensor = c;
        this.calibrate();
    }

    public void setI2C(int newAddress) {
        colorsensor.setI2cAddress(newAddress);
    }

    public int red() {
        return Math.abs(colorsensor.red() - offsetRed);
    }
    public int green() {
        return Math.abs(colorsensor.green() - offsetGreen);
    }
    public int blue() {
        return Math.abs(colorsensor.blue() - offsetBlue);
    }

    public int alpha() {
        return Math.abs(colorsensor.alpha() - offsetAlpha);
    }

    public Color getNaturalColor() {
        return Color.NONE;
    }

    public void setThreshold(int t) {
        threshold = t;
    }

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
