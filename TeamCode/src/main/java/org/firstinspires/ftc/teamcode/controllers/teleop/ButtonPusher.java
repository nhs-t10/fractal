package org.firstinspires.ftc.teamcode.controllers.teleop;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.organs.Pusher;
import org.firstinspires.ftc.teamcode.statics.ControlParser;
import org.firstinspires.ftc.teamcode.statics.Controls;

/**
 * Created by nhs on 10/21/16.
 */

public class ButtonPusher implements Controller {
    private Pusher pusher;
    public ButtonPusher (Pusher p) {
        pusher = p;
    }
    public boolean tick() {
        if(ControlParser.button(Controls.LeftPush)) pusher.moveTo(0.1);
        else if(ControlParser.button(Controls.RightPush)) pusher.pushRight();
        return false;
    }
}
