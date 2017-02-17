package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.organs.ButtonRoller;
import org.firstinspires.ftc.teamcode.organs.SecondButtonRoller;

/**
 * Created by Jacob on 2/15/2017.
 */

public class PrepForAuto implements Controller{
    private ButtonRoller buttonRoller;
    private SecondButtonRoller secondButtonRoller;
    private boolean rollersReady = false;

    public PrepForAuto(){
        buttonRoller = new ButtonRoller();
        secondButtonRoller = new SecondButtonRoller();
    }

    public boolean tick(){
        secondButtonRoller.close();
        return buttonRoller.autoUnwind();
    }
}