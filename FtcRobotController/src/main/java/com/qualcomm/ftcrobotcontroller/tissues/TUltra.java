package com.qualcomm.ftcrobotcontroller.tissues;

import com.qualcomm.ftcrobotcontroller.debug.Component;
import com.qualcomm.ftcrobotcontroller.debug.Logger;
import com.qualcomm.robotcore.hardware.AnalogInput;

/**
 * Created by max on 4/17/16.
 */
public class TUltra extends Component {
    private AnalogInput ultrasonic;
    public String name = "Ultrasonic";

    public TUltra(AnalogInput u) {
        ultrasonic = u;
    }

    public double distance() {
        return ultrasonic.getValue();
    }

    public Boolean test() {
        Logger.logLine("distance: " + this.distance());
        return true;
    }
}
