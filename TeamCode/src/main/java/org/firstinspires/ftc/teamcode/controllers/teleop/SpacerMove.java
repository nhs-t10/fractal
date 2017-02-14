package org.firstinspires.ftc.teamcode.controllers.teleop;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.organs.Spacers;
import org.firstinspires.ftc.teamcode.statics.ControlParser;
import org.firstinspires.ftc.teamcode.statics.Controls;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TMotor;

/**
 * Created by max on 2/2/17.
 */
public class SpacerMove implements Controller {
    private Spacers spacers;
    public SpacerMove(Spacers spacers) {
        this.spacers = spacers;
    }
    public boolean tick() {
        if (ControlParser.button(Controls.SpacerDown)) {
            spacers.raise();
        }
        else if (ControlParser.button(Controls.SpacerUp)) {
            spacers.lower();
        }
        else if (ControlParser.button(Controls.SpacerAuto)) spacers.raiseUntil();
        else spacers.stop();
        Logger.logLine("" + spacers.isTouchingRight() + " " + spacers.isTouchingLeft());
        return false;
    }
}
