package org.firstinspires.ftc.teamcode.controllers.teleop;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.neurons.DebouncingButton;
import org.firstinspires.ftc.teamcode.organs.Pusher;
import org.firstinspires.ftc.teamcode.statics.ControlParser;
import org.firstinspires.ftc.teamcode.statics.Controls;

/**
 * Created by nhs on 10/21/16.
 */

public class ButtonPusher implements Controller {
    private Pusher pusher;
    private DebouncingButton toggle;
    public ButtonPusher (Pusher p) {
        pusher = p;
        toggle = new DebouncingButton(Controls.ToggleBtn);
    }
    public boolean tick() {
        if(toggle.getToggle()) pusher.toggle();
        else if(ControlParser.button(Controls.PushBtn)) pusher.pushButton();
        return false;
    }
}
