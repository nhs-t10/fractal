package org.firstinspires.ftc.teamcode.tissues;

import com.qualcomm.robotcore.hardware.AnalogInput;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.statics.Hardware;

/**
 * Created by max on 4/17/16.
 */
public class TUltra implements Component {
    //Vcc = voltage input
    //(Vcc/1024) = V/cm
    private float inputVoltage = 1.0f;

    private AnalogInput ultrasonic;
    public String getName(){return "Ultrasonic";}
    private boolean disabled = false;

    public TUltra(String u) {this(u, false);}
    public TUltra(String u, boolean disabled) {
        this.disabled = disabled;
        if(!disabled) ultrasonic = Hardware.getHardwareMap().analogInput.get(u);
    }

    /**
     * Gets the value being returned by the ultrasonic.
     * @return value read from sensor
     */
    public double voltage() {
        if(disabled) return -1;
        return ultrasonic.getVoltage();
    }

    public double distance() {
        if(disabled) return -1;
        return voltage()/inputVoltage;
    }

    public boolean test() {
        Logger.logLine("distance: " + this.distance());
        return true;
    }
}
