package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.organs.Spacers;

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
            return true;
        }
        else return false;
    }
}
