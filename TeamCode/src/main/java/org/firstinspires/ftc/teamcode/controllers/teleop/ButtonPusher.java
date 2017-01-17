package org.firstinspires.ftc.teamcode.controllers.teleop;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.DebouncingButton;
import org.firstinspires.ftc.teamcode.organs.Pusher;
import org.firstinspires.ftc.teamcode.statics.ControlParser;
import org.firstinspires.ftc.teamcode.statics.Controls;

/**b
 * Created by nhs on 10/21/16.
 */

public class ButtonPusher implements Controller {
    private Pusher pusher;
    private DebouncingButton toggleL;
    private DebouncingButton toggleR;
    public ButtonPusher (Pusher p) {
        pusher = p;
        toggleR = new DebouncingButton(Controls.RightToggleBtn);
        toggleL = new DebouncingButton(Controls.LeftToggleBtn);
    }
    public boolean tick() {
        if(toggleR.getToggle()) {pusher.toggle(true);}
        else if(toggleL.getToggle()) {pusher.toggle(false);}
        else if(ControlParser.button(Controls.RightPushBtn)) {
            Logger.logLine("Righter");
            pusher.pushButton(true);}
        else if(ControlParser.button(Controls.LeftPushBtn)) {pusher.pushButton(false);}
        return false;
    }
}
