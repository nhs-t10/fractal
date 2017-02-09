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
    private TCRServo servo;
    private TTouch contactLeft;
    public Spacers() {
        servo = new TCRServo(Hardware.ServoSpacers);
        contactLeft = new TTouch(Hardware.ContactLeft);
    }
    public void lower() {
        servo.move(1f);
        Sleep.secs(1);
        servo.stop();
    }
    public void raise() {
        servo.move(1f);
        Sleep.secs(1);
        servo.stop();
    }

    public boolean isTouchingLeft() {
        return contactLeft.isPressed();
    }
    public boolean isTouchingRight() {
        return true;
    }

    public boolean test() {
        return true;
    }
}
