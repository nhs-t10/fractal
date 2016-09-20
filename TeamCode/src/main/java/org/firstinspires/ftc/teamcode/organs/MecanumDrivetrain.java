package org.firstinspires.ftc.teamcode.organs;

/**
 * Created by will on 9/20/16.
 */
public class MecanumDrivetrain extends TreadDrivetrain {
    public void driveSideways(float power) {
        driveQuad(power, -power, -power, power);
    }
}
