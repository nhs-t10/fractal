package org.firstinspires.ftc.teamcode.controllers.teleop;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.statics.ControlParser;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TMotor;

/**
 * Created by max on 2/2/17.
 */
public class Tray implements Controller {
    private TMotor tray = new TMotor(Hardware.ClydeTray);
    public boolean tick() {
        if (ControlParser.button("LT1")) {
            tray.move(1f);
        }
        else if (ControlParser.button("LB1")) {
            tray.move(-1f);
        }
        else tray.stop();
        return false;
    }
}
