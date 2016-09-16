package org.firstinspires.ftc.teamcode.organs;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.lib.Sleep;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TMotor;

/**
 * Created by robotics on 5/31/16.
 */
public class Gimbal implements Component {
    public String getName() {return "Jonathan's 2 axis Gimbal";}
    public TMotor MHorizontal, MVertical;
    public Gimbal() {
        MHorizontal = new TMotor(Hardware.GimbalHorizontal);
        MVertical = new TMotor(Hardware.GimbalVertical);
    }
    public void moveHorizontal(float speed) {
        MHorizontal.move(speed);
    }
    public void moveVertical(float speed) {
        MVertical.move(speed);
    }
    public void stopHorizontal() {
        MHorizontal.stop();
    }
    public void stopVertical() {
        MVertical.stop();
    }
    public Boolean test() {
        moveHorizontal(0.2f);
        Sleep.secs(2);
        stopHorizontal();

        moveVertical(0.2f);
        Sleep.secs(2);
        stopVertical();

        return true;
    }
}
