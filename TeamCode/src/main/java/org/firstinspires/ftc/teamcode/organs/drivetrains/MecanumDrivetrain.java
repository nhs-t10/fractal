package org.firstinspires.ftc.teamcode.organs.drivetrains;

/**
 * Created by will on 9/20/16.
 */
public class MecanumDrivetrain extends TreadDrivetrain {
    //Mecanum
    private static final float MECANUM_OFFSET = 0.07f;

    public void driveSideways(float power) {
        driveQuad(power*(1-MECANUM_OFFSET), -power, -power, power*(1-MECANUM_OFFSET));
    }
}
