package org.firstinspires.ftc.teamcode.organs;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.lib.Sleep;
import org.firstinspires.ftc.teamcode.neurons.Time;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TCRServo;
import org.firstinspires.ftc.teamcode.tissues.TServo;
import org.firstinspires.ftc.teamcode.tissues.TTouch;

/**
 * Created by max on 2/8/17.
 */
public class Spacers implements Component {
    public String getName() { return "Spacers"; }
    private TCRServo servo;
    private TTouch contactLeft;
    private TTouch contactRight;
    private Time.Stopwatch sw;

    private boolean topTouched = false;
    public Spacers() {
        servo = new TCRServo(Hardware.Spacer);
        contactLeft = new TTouch(Hardware.ContactLeft);
        contactRight = new TTouch(Hardware.ContactRight);
        sw = new Time.Stopwatch();
    }
    public void lower() {
        servo.move(1f);
    }
    public void raise() {
        servo.move(-1f);
    }
    public boolean raiseUntil() {
        if (!isTouchingLeft() || !isTouchingRight()) lower();
            else stop();
        return isTouchingLeft() && isTouchingRight();
    }
    public boolean raiseProper() {
        if(isTouchingLeft() && isTouchingRight()) topTouched = true;
        if(topTouched) {
            if(!isTouchingLeft() || !isTouchingRight()) {
                stop();
                return true;
            }
            else lower();
        }
        else raise();
        return false;
    }
    public void stop(){
        servo.stop();
    }
    public void lowerTimed(double t){
        sw.start();
        if (sw.timeElapsed() < t){
            lower();
        }
        else stop();
    }
    public void raiseTimed(int t){
        raise();
        Sleep.ms(t);
        stop();
    }

    public boolean isTouchingLeft() {
        return !contactLeft.isPressed();
    }
    public boolean isTouchingRight() {
        return !contactRight.isPressed();
    }

    public boolean test() {
        lower();
        raise();
        return true;
    }
}
