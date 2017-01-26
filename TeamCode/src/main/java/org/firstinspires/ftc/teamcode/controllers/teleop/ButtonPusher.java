package org.firstinspires.ftc.teamcode.controllers.teleop;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.neurons.DebouncingButton;
import org.firstinspires.ftc.teamcode.organs.Pusher;
import org.firstinspires.ftc.teamcode.statics.Controls;

/**b
 * Created by nhs on 10/21/16.
 */

public class ButtonPusher implements Controller {
    private Pusher pusher;
    private DebouncingButton toggleL;
    private DebouncingButton toggleR;
    private DebouncingButton toggleBoth;
    public ButtonPusher (Pusher p) {
        pusher = p;
        toggleR = new DebouncingButton(Controls.RightPushBtn);
        toggleL = new DebouncingButton(Controls.LeftPushBtn);
        toggleBoth = new DebouncingButton(Controls.BothPushBtn) ;
    }
    public boolean tick() {
        if(toggleR.getToggle()) {pusher.pushRight();}
        else if(toggleL.getToggle()) {pusher.pushLeft();}
        else if(toggleBoth.getToggle()) {pusher.pushBoth();}
        return false;
    }
}
