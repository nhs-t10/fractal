package com.qualcomm.ftcrobotcontroller.tissues;

import com.qualcomm.ftcrobotcontroller.debug.Test;
import com.qualcomm.robotcore.hardware.AnalogInput;

/**
 * Created by max on 4/17/16.
 */
public class TUltra implements Test {
    private AnalogInput ultrasonic;

    public TUltra(AnalogInput u) {
        ultrasonic = u;
    }

    public double distance() {
        return ultrasonic.getValue();
    }

    public String test() {
        return "Distance: " + this.distance();
    }
}
