package org.firstinspires.ftc.teamcode.controllers.teleop;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.organs.archive.Gimbal;
import org.firstinspires.ftc.teamcode.statics.ControlParser;
import org.firstinspires.ftc.teamcode.statics.Controls;

/**
 * Created by robotics on 5/31/16.
 */
public class GimbalBumpers implements Controller {
    private Gimbal gimbal;
    public GimbalBumpers(Gimbal g) {
        gimbal = g;
    }
    public boolean tick() {
        if(ControlParser.button(Controls.HorizontalGimbal)) {
            gimbal.moveHorizontal(-0.5f);
            gimbal.moveVertical(0.25f);
        }
        else gimbal.stopHorizontal();
        if(ControlParser.button(Controls.VerticalGimbal)) gimbal.moveVertical(0.5f);
        else gimbal.stopVertical();
        return false;
    }
}
