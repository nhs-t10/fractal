package org.firstinspires.ftc.teamcode.controllers.teleop;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
import org.firstinspires.ftc.teamcode.neurons.JoyDegrees;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;
import org.firstinspires.ftc.teamcode.statics.ControlParser;
import org.firstinspires.ftc.teamcode.statics.Controls;

import java.util.ArrayList;

/**
 * Created by max on 2/11/17.
 */
public class AutoAngle implements Controller {
    private Instruments instruments;
    private DriveTrain driveTrain;

    private boolean released = false;
    private AngleTurning angleTurning;
    public AutoAngle(Instruments instruments, DriveTrain driveTrain) {
        this.driveTrain = driveTrain;
        this.instruments = instruments;
    }
    public boolean tick() {
        boolean click = ControlParser.button(Controls.AutoAim);
        if(!released) {
            Logger.logLine("theta: " + JoyDegrees.toDeg(ControlParser.range(Controls.AimStick)));
            if(click) return false;
            else {
                released = true;
                angleTurning = new AngleTurning(JoyDegrees.toDeg(ControlParser.range(Controls.AimStick)));
            }
        }
        ArrayList<Float> values = angleTurning.getPivotPowers(instruments.yaw);
        if (values.get(0) == 0.0 && values.get(1) == 0.0) {
            driveTrain.stop();
            return true;
        }
        driveTrain.drive(values.get(0), values.get(1));
        return false;
    }
}
