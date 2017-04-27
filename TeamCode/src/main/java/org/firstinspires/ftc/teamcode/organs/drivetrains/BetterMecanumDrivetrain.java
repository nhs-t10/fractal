package org.firstinspires.ftc.teamcode.organs.drivetrains;

import org.firstinspires.ftc.teamcode.lib.Sleep;
import java.lang.Math;
/**
 * Created by will on 9/20/16.
 */
public class BetterMecanumDrivetrain extends TreadDrivetrain {
    //Mecanum
    @Override
    public String getName() {return "Mecanum Drive Train";}
    private static final float MECANUM_OFFSET = 0.00f;

    public static float[] convertToPower(float angle, double power) {
        double pairAPower = (Math.sin(Math.toRadians(angle)) + Math.cos(Math.toRadians(angle))) * power;
        double pairBPower = (Math.sin(Math.toRadians(angle)) - Math.cos(Math.toRadians(angle))) * power;
        float aPowerValues = (float)pairAPower;
        float bPowerValues = (float)pairBPower;
        float[] leftrightPower = {aPowerValues, bPowerValues};
        return leftrightPower;
    }
    @Override
    public boolean test() {
        this.convertToPower(0f, .5);
        Sleep.secs(2);
        this.convertToPower(90f, -.5);
        Sleep.secs(2);
        this.convertToPower(45f, .5);
        Sleep.secs(2);
        this.convertToPower(180f, 1);
        Sleep.secs(2);
        this.stop();
        return true;
    }
}
