package org.firstinspires.ftc.teamcode.organs;

import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Admin on 4/18/2016.
 */
public class TwoWheelDriveTrain extends DriveTrain {
    private TMotor leftWheel, rightWheel;
    public String getName(){return "Two Wheel Drive Train";}
    public TwoWheelDriveTrain() {
        leftWheel = new TMotor(Hardware.MotorLeftFront);
        rightWheel = new TMotor(Hardware.MotorRightFront);
    }

    public void drive(float left, float right) {
        leftWheel.move(left);
        rightWheel.move(right);
    }
}
