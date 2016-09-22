package org.firstinspires.ftc.teamcode.organs;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TMotor;

/**
 * Created by robotics on 9/22/16.
 */
public class JonFlicker implements Component {
    private TMotor flicker;

    public JonFlicker() {
        flicker = new TMotor(Hardware.ModuleMotor1);
    }

    public void move(float power) {
        flicker.move(power);
    }

    @Override
    public String getName() {
        return "Jonothan's Ball Flicker";
    }

    @Override
    public Boolean test() {
        return null;
    }
}
