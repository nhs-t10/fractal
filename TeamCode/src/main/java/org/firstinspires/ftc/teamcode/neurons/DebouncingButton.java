package org.firstinspires.ftc.teamcode.neurons;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.statics.ControlParser;

/**
 * Created by nhs on 10/25/16.
 * To use: in constructor, give a ControlParser.button string.
 * Call getToggle(), you will get a `true` value exactly once for every time the button is pressed.
 */

public class DebouncingButton {
    private boolean debounce = false;
    private String ctrl;
    public DebouncingButton(String control) {
        ctrl = control;
    }
    public boolean getToggle() {
        boolean status = ControlParser.button(ctrl);
        if (!debounce && status) {
            debounce = true;
            return true;
        }
        else if (!status) {
            debounce = false;
        }
        return false;
    }
    public String getCtrl() {
        return ctrl;
    }
}
