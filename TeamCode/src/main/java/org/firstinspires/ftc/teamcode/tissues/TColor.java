package org.firstinspires.ftc.teamcode.tissues;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.lib.AdafruitColor;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import android.graphics.Color;

/**
 * Created by max on 4/17/16.
 */
public class TColor implements Component {
    private AdafruitColor colorsensor;

    public String getName(){return "Color";}

    private int offsetRed, offsetGreen, offsetBlue, offsetAlpha;
    private int threshold = 50;

    public enum ColorType {
        RED, BLUE, WHITE, NONE
    }

    public TColor(String c) {
        colorsensor = new AdafruitColor(Hardware.getHardwareMap(), c);
        this.calibrate();
    }


    /**
     * Sets gain
     * @param gain
     */
    public void setGain(int gain) { colorsensor.setGain(gain); }

    /**
     * Sets the integration time
     * @param ms
     */
    public void setIntegration(double ms) { colorsensor.setIntegrationTime(ms); }

    /**
     * Gets the red of the color sensor
     * @return red value read by the color sensor
     */
    public int red() {
        return Math.abs(colorsensor.redColor() - offsetRed);
    }

    /**
     * Gets the green of the color sensor
     * @return green value read by the color sensor
     */
    public int green() {
        return Math.abs(colorsensor.greenColor() - offsetGreen);
    }

    /**
     * Gets the blue of the color sensor
     * @return blue value read by the color sensor
     */
    public int blue() {
        return Math.abs(colorsensor.blueColor() - offsetBlue);
    }

    /**
     * Gets HSV of color sensor
     * @return hsv values
     */
    public float[] hsv() {
        float hsvValues[] = {0F,0F,0F};
        Color.RGBToHSV((red() * 255) / 800, (green() * 255) / 800, (blue() * 255) / 800, hsvValues);
        return hsvValues;
    }

    /**
     * Gets the alpha of the color sensor
     * @return alpha value read by the color sensor
     */
    public int alpha() {
        return Math.abs(colorsensor.clearColor() - offsetAlpha);
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
        offsetRed = colorsensor.redColor();
        offsetGreen = colorsensor.greenColor();
        offsetBlue = colorsensor.blueColor();
        offsetAlpha = colorsensor.clearColor();
    }

    public boolean test() {
        Logger.logLine("r:" + this.red() + " g:" + this.green() + " b:" + this.blue());
        return true;
    }
}
