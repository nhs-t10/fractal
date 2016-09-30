package org.firstinspires.ftc.teamcode.tissues;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.statics.Hardware;

import com.qualcomm.robotcore.hardware.AnalogInput;

/**
 * Created by max on 4/17/16.
 */
public class TUltra implements Component {
    //Vcc = voltage input
    //(Vcc/1024) = V/cm
    private AnalogInput ultrasonic;
    public String getName(){return "Ultrasonic";}

    public TUltra(String u) {
        ultrasonic = Hardware.getHardwareMap().analogInput.get(u);
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
