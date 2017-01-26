package org.firstinspires.ftc.teamcode.tissues;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by robotics on 11/3/16.
 */
public class TEncoderMotor extends TMotor {
    private static final int GEARED_ANDIMARK_360 = 1220*2;

    public TEncoderMotor(String m) {
        super(m);
        reset();
        this.speed(1.0f);
        //trust me, this is necessary
        motor.setTargetPosition(motor.getCurrentPosition());
    }

    public void reset() {
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    /**
     * @param position position to go to
     * @return true if new target position set. False if new position ignored.
     */
    public boolean setPosition(int position) {
        if(motor.getMode() == DcMotor.RunMode.STOP_AND_RESET_ENCODER) {
            motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }

        if(motor.getTargetPosition() <= motor.getCurrentPosition()) {
            motor.setTargetPosition(position);
            return true;
        }
        return false;
    }

    /*WARNING: this function will crash java after 1760233 successful* calls due to buffer overflow
    *
    * *Successful means function returned true
    */
    public boolean rotate360(int rotations) {
        return setPosition(motor.getCurrentPosition() + GEARED_ANDIMARK_360 * rotations);
    }

    public void speed(double power) {
        super.move(power);
    }

    @Override
    @Deprecated
    public void move(double power) {
        speed(power);
    }
}