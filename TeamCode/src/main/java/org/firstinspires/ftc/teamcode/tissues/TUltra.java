package org.firstinspires.ftc.teamcode.tissues;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.debug.Logger;
import com.qualcomm.robotcore.hardware.AnalogInput;

/**
 * Created by max on 4/17/16.
 */
public class TUltra implements Component {
    private AnalogInput ultrasonic;
    public String getName(){return "Ultrasonic";}

    public TUltra(AnalogInput u) {
        ultrasonic = u;
    }

    /**
     * Gets the value being returned by the ultrasonic.
     * @return value read from sensor
     */
    public double distance() {
        return ultrasonic.getVoltage();
    }

    public Boolean test() {
        Logger.logLine("distance: " + this.distance());
        return true;
    }
}
