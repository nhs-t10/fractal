package org.firstinspires.ftc.teamcode.organs;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.lib.Sleep;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TCRServo;
import org.firstinspires.ftc.teamcode.tissues.TServo;
import org.firstinspires.ftc.teamcode.tissues.TTouch;

/**
 * Created by max on 2/8/17.
 */
public class Spacers implements Component {
    public String getName() { return "Spacers"; }
    private TCRServo servoRight;
    private TCRServo servoLeft;
    private TTouch contactLeft;
    private TTouch contactRight;
    public Spacers() {
        servoLeft = new TCRServo(Hardware.SpacerLeft);
        servoRight = new TCRServo(Hardware.SpacerRight);
        contactLeft = new TTouch(Hardware.ContactLeft);
        contactRight = new TTouch(Hardware.ContactRight);
    }
    public void lower() {
        servoRight.move(1f);
        servoLeft.move(1f);
        Sleep.secs(1);
        servoRight.stop();
        servoLeft.stop();
    }
    public void raise() {
        servoLeft.move(-1f);
        servoRight.move(-1f);
        Sleep.secs(1);
        servoLeft.stop();
        servoRight.stop();
    }

    public boolean isTouchingLeft() {
        return contactLeft.isPressed();
    }
    public boolean isTouchingRight() {
        return contactRight.isPressed();
    }

    public boolean test() {
        lower();
        raise();
        return true;
    }
}
