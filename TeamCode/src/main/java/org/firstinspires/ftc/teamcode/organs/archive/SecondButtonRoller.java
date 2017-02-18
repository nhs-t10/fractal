package org.firstinspires.ftc.teamcode.organs.archive;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TServo;

/**
 * Created by Jacob on 2/15/2017.
 */

@Deprecated
//Use superior RollerStopper plz :P
public class SecondButtonRoller implements Component {
    public String getName() { return "SecondButtonRoller"; }
    private TServo secondButtonRoller;

    private boolean open;

    public SecondButtonRoller(){
        secondButtonRoller = new TServo(Hardware.SecondButtonRoller);
        open = false;
        close();
    }

    public void open(){ secondButtonRoller.moveTo(.6);  }
    public void close(){ secondButtonRoller.moveTo(.5); }
    public boolean test(){
        open();
        close();
        return true;
    }
}
