package org.firstinspires.ftc.teamcode.controllers.tests;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.statics.ControlParser;

/**
 * Created by max on 6/2/16.
 *
 * Use for testing simple mappings!
 */
public class ButtonTest implements Controller {
    private String control;
    public ButtonTest(String ctrl) {
        control = ctrl;
    }
    public boolean tick() {
        if(ControlParser.button(control)) {
                Logger.logLine("Button " + control + " pressed!");
        }
        return false;
    }
}
