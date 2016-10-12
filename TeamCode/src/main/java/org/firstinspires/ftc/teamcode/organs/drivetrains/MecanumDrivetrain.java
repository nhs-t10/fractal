package org.firstinspires.ftc.teamcode.organs.drivetrains;

import org.firstinspires.ftc.teamcode.lib.Sleep;

/**
 * Created by will on 9/20/16.
 */
public class MecanumDrivetrain extends TreadDrivetrain {
    //Mecanum
    @Override
    public String getName() {return "Mecanum Drive Train";}
    private static final float MECANUM_OFFSET = 0.1f;

    public void driveSideways(float power) {
        driveQuad(power*(1-MECANUM_OFFSET), -power, -power, power*(1-MECANUM_OFFSET));
    }
    @Override
    public boolean test() {
        this.goForward(0.5f);
        Sleep.secs(2);
        this.goBackward(0.5f);
        Sleep.secs(2);
        this.driveSideways(0.5f);
        Sleep.secs(2);
        this.driveSideways(-0.5f);
        Sleep.secs(2);
        this.stop();
        return true;
    }
}
