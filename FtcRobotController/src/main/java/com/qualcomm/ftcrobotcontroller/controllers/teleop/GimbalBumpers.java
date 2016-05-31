package com.qualcomm.ftcrobotcontroller.controllers.teleop;

import com.qualcomm.ftcrobotcontroller.controllers.Controller;
import com.qualcomm.ftcrobotcontroller.organs.Gimbal;
import com.qualcomm.ftcrobotcontroller.statics.ControlParser;
import com.qualcomm.ftcrobotcontroller.statics.Controls;

/**
 * Created by robotics on 5/31/16.
 */
public class GimbalBumpers implements Controller {
    private Gimbal gimbal;
    public GimbalBumpers(Gimbal g) {
        gimbal = g;
    }
    public boolean tick() {
        if(ControlParser.button(Controls.HorizontalGimbal).get(0)) {
            gimbal.moveHorizontal(-0.25f);
            gimbal.moveVertical(0.125f);
        }
        else gimbal.stopHorizontal();
        if(ControlParser.button(Controls.VerticalGimbal).get(0)) gimbal.moveVertical(0.5f);
        else gimbal.stopVertical();
        return false;
    }
}
