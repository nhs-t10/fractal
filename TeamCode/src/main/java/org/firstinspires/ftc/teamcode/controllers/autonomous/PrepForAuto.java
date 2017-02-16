package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.organs.SecondButtonRoller;

/**
 * Created by Jacob on 2/15/2017.
 */

public class PrepForAuto implements Controller{
    private SecondButtonRoller secondButtonRoller;
    private boolean rollersReady = false;

    public PrepForAuto(){
        secondButtonRoller = new SecondButtonRoller();
    }

    public boolean tick(){
        if (rollersReady){
            return true;
        }
        else {
            secondButtonRoller.open();
            rollersReady = true;
            return false;
        }
    }
}
