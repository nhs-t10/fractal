package org.firstinspires.ftc.teamcode.controllers.autonomous;

import com.qualcomm.robotcore.robot.Robot;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.organs.Spacers;
import org.firstinspires.ftc.teamcode.statics.RobotState;

/**
 * Created by Jacob on 2/14/2017.
 */

public class PrepSpacers implements Controller{
    private Spacers spacers;
    public PrepSpacers(){
        spacers = new Spacers();
    }
    public boolean tick() {
        if (spacers.raiseProper()){
            RobotState.spacersDropped = true;
            return true;
        }
        else return false;
    }
}
