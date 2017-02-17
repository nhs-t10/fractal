package org.firstinspires.ftc.teamcode.organs;

import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TServo;

/**
 * Created by robotics on 2/16/17.
 */
public class RollerStopper extends Stopper {
    public RollerStopper() {
        this.stopper = new TServo(Hardware.SecondButtonRoller);
        this.open = false;

        this.openVal =  0.8;
        this.closeVal = 0.5;
        close();
    }
}
