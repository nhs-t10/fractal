package org.firstinspires.ftc.teamcode.tissues;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.lib.Sleep;
import org.firstinspires.ftc.teamcode.neurons.Time;
import org.firstinspires.ftc.teamcode.statics.Hardware;

/**
 * Created by robotics on 4/12/16.
 */
public class TMotor implements Component {
    protected DcMotor motor;
    private Time.Stopwatch stopwatch;
    private double prevPower = 0.0;

    public TMotor(String m) {
        motor = Hardware.getHardwareMap().dcMotor.get(m);
        stopwatch = new Time.Stopwatch();
    }

    /**
     * Sets the direction of the motor
     * @param dir true = forward; false = backward
     */
    public void setDirection(boolean dir) {
        motor.setDirection((dir ? DcMotor.Direction.FORWARD : DcMotor.Direction.REVERSE));
    }

    /**
     * Sets the TMotor's power to a given amount.
     * @param power value between -1.0 and 1.0. Negative values move motor in reverse
     *              direction.
     */
    public void move(double power) {
        power = (float) Range.clip(power, -1.0, 1.0);
        if (prevPower == power) return;
        else prevPower = power;
        motor.setPower(power);
    }

    public boolean moveFor(double power, int millis) {
        if(!stopwatch.isRecording()) {
            stopwatch.start();
        }

        if(stopwatch.timeElapsed() > millis) { 
            this.stop();
            stopwatch.stop();
            return true;
        } else {
            move(power);
            return false;
        }
    }

    /**
     * Sets the TMotor's power to 0.
     */
    public void stop() {
        motor.setPower(0);
    }

    public void turnForMillis(int millis) {

    }

    public String getName(){
        return  motor.getDeviceName();
    }

    public boolean test() {
        this.move(0.5f);
        Sleep.secs(2);
        this.stop();
        return true;
    }
}

//TODO: Encoder support
