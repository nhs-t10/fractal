package org.firstinspires.ftc.teamcode.controllers.tests;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.DebouncingButton;

/**
 * Created by max on 6/2/16.
 *
 * Use for testing simple mappings!
 */
public class ButtonTest implements Controller {
    private DebouncingButton db;
    public ButtonTest(String ctrl) {
        db = new DebouncingButton(ctrl);
    }
    public boolean tick() {
        if(db.getToggle()) {
                Logger.logLine("Button " + db.getCtrl() + " pressed!");
        }
        return false;
    }
}
