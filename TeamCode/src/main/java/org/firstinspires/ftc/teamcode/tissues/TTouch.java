package org.firstinspires.ftc.teamcode.tissues;

import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.statics.Hardware;

/**
 * Created by robotics on 12/6/16.
 */
public class TTouch implements Component {
    private TouchSensor touch;

    public TTouch(String t) {
        touch = Hardware.getHardwareMap().touchSensor.get(t);
    }

    public boolean isPressed() {
        return touch.isPressed();
    }

    @Override
    public String getName() {
        return "Touch Sensor";
    }

    @Override
    public boolean test() {
        return false;
    }
}
