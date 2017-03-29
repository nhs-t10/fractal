package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.organs.ButtonRoller;
import org.firstinspires.ftc.teamcode.organs.RollerStopper;

/**
 * Created by Jacob on 2/15/2017.
 */

public class PrepForAuto implements Controller{
//    private ButtonRoller buttonRoller;
    private RollerStopper secondButtonRoller;
    private boolean rollersReady = false;

    public PrepForAuto() {
//        buttonRoller = br;
        secondButtonRoller = new RollerStopper();

    }


    public boolean tick(){
        secondButtonRoller.open();
//        buttonRoller.lock(true);
//        return buttonRoller.autoUnwind();
        return true;
    }
}