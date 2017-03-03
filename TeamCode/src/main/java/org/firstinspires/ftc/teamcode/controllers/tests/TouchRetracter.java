package org.firstinspires.ftc.teamcode.controllers.tests;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.organs.ButtonRoller;
import org.firstinspires.ftc.teamcode.organs.RollerStopper;
import org.firstinspires.ftc.teamcode.organs.Spacers;

/**
 * Created by max on 2/18/17.
 */
public class TouchRetracter implements Controller {
    private RollerStopper rollerStopper;
    private ButtonRoller buttonRoller;
    private Spacers spacers;

    private boolean debounce = false;
    public TouchRetracter(RollerStopper rollerStopper, ButtonRoller buttonRoller, Spacers spacers) {
        this.rollerStopper = rollerStopper;
        this.buttonRoller = buttonRoller;
        this.spacers = spacers;
    }
    public boolean tick() {
        if(spacers.isTouchingRight()) spacers.lower();
        else spacers.stop();
        
        if(buttonRoller.isTouching()) buttonRoller.wind();
        else buttonRoller.stop();

        if(!debounce && spacers.isTouchingLeft()) {
            debounce = true;
            rollerStopper.toggle();
        }
        else if(!spacers.isTouchingLeft()) {
            debounce = false;
        }
        return false;
    }
}
