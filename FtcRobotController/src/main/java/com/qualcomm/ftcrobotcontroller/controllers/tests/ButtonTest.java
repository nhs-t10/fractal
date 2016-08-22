package com.qualcomm.ftcrobotcontroller.controllers.tests;

import com.qualcomm.ftcrobotcontroller.controllers.Controller;
import com.qualcomm.ftcrobotcontroller.debug.Logger;
import com.qualcomm.ftcrobotcontroller.statics.ControlParser;

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
