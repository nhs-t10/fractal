package org.firstinspires.ftc.teamcode.organs;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.lib.Lock;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TCRServo;
import org.firstinspires.ftc.teamcode.tissues.TTouch;

/**
 * Created by Jacob on 2/15/2017.
 */

public class ButtonRoller implements Component {
    public String getName() { return "ButtonRoller"; }
    private TCRServo servo;
    private TTouch unwinder;
    private Lock lock = new Lock();

    public ButtonRoller(){
        servo = new TCRServo(Hardware.ButtonRoller);
        unwinder = new TTouch(Hardware.Unwinder);
    }
    public void unwind(){servo.move(1f);}
    public void wind(){servo.move(-1f);}
    public void stop(){servo.move(0);}
    public boolean autoUnwind(){
        if (unwinder.isPressed()){
            stop();
            return true;
        }
        else{
            unwind();
            return false;
        }
    }
    public boolean isTouching() {
        return unwinder.isPressed();
    }

    public void lock(boolean status) {
        if(status) lock.lock();
        else lock.ulock();
    }

    public boolean inUse() {
        return lock.isLocked();
    }

    public boolean test(){
        unwind();
        wind();
        return true;
    }
}
