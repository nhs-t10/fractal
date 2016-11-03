package org.firstinspires.ftc.teamcode.tissues;

import com.qualcomm.robotcore.hardware.AnalogInput;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.statics.Hardware;

/**
 * Created by jacob_000 on 11/3/2016.
 */
public class TLight implements Component {
    private float inputVoltage=1.0f;
    private AnalogInput lightsensor;
    public String getName(){return "Ultrasonic";}
    public TLight(String l) {
        lightsensor = Hardware.getHardwareMap().analogInput.get(l);
    }
    public double voltage() {
        return lightsensor.getVoltage();
    }

    public double reflectedValue() {
        return voltage()/inputVoltage;
    }

    public boolean test() {
        Logger.logLine("reflectedValue: " + this.reflectedValue());
    return true;
    }
}
