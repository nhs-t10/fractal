package org.firstinspires.ftc.teamcode.controllers.teleop;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.neurons.DebouncingButton;

/**
 * Created by max on 12/7/16.
 */
public class OnButtonPress implements Controller {
    private DebouncingButton db;
    public OnButtonPress(String ctrl) {
        db = new DebouncingButton(ctrl);
    }
    public boolean tick() {
        return db.getToggle();
    }
}
