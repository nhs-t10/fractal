package org.firstinspires.ftc.teamcode.organs.drivetrains;

import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TMotor;

/**
 * Created by max on 4/17/16.
 */
public class QuadDrivetrain extends DriveTrain {
    private TMotor leftRear, leftFront, rightRear, rightFront;
    public String getName() {return "Quad Drivetrain";}
    public QuadDrivetrain() {
        leftRear = new TMotor(Hardware.MotorLeftRear);
        leftFront = new TMotor(Hardware.MotorLeftFront);
        rightRear = new TMotor(Hardware.MotorRightRear);
        rightFront = new TMotor(Hardware.MotorRightFront);
    }

    /**
    * Drives using all four motors
     * @param lF left front motor
     * @param lR left rear motor
     * @param rF right front motor
     * @param rR right rear motor
    * */
    public void driveQuad(float lR, float lF, float rR, float rF) {
        leftRear.move(lR);
        leftFront.move(lF);
        rightRear.move(rR);
        rightFront.move(rF);
    }

    public void doDrive(float left, float right) {
        this.driveQuad(left, left, right, right);
    }
}
