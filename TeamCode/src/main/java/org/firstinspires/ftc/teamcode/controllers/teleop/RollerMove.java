package org.firstinspires.ftc.teamcode.controllers.teleop;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.organs.ButtonRoller;
import org.firstinspires.ftc.teamcode.statics.ControlParser;
import org.firstinspires.ftc.teamcode.statics.Controls;

/**
 * Created by Jacob on 2/15/2017.
 */

public class RollerMove implements Controller{
    private ButtonRoller buttonRoller;
    public RollerMove(ButtonRoller buttonRoller){
        this.buttonRoller = buttonRoller;
    }
    public boolean tick(){
        if (ControlParser.button(Controls.RollerUnwind)){buttonRoller.unwind();}
        else if (ControlParser.button(Controls.RollerWind)){buttonRoller.wind();}
        else buttonRoller.stop();
        return false;
    }
}
