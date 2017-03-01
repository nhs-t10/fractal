package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
import org.firstinspires.ftc.teamcode.neurons.LineDetection;
import org.firstinspires.ftc.teamcode.neurons.Time;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.Spacers;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TTouch;

import java.util.ArrayList;
import java.util.Timer;

/**
 * Created by Jack on 2/28/2017.
 */

public class CorrectiveMeasures implements Controller{
    private Instruments instruments;
    private MecanumDrivetrain mecanumDrivetrain;
    private TTouch spacerL;
    private TTouch spacerR;
    private AngleTurning at;
    private LineDetection ld;
    private Time.Stopwatch sw;
    private float s;
    private boolean useful = false;
    private boolean backUp = false;
    private boolean aligned = false;
    public CorrectiveMeasures(Instruments i, MecanumDrivetrain d, float speed){
        s = speed;
        sw = new Time.Stopwatch();
        instruments = i;
        mecanumDrivetrain = d;
        spacerL = new TTouch(Hardware.ContactLeft);
        spacerR = new TTouch(Hardware.ContactRight);
        at = new AngleTurning(-90);
        ld = new LineDetection();
    }
    public boolean tick(){
        if (!useful) {
            if (!(spacerL.isPressed() || spacerR.isPressed())) {
                return true;
            }
            sw.start();
            useful = true;
        }

        if (!backUp && useful){
            if(instruments.distance >= .2 && sw.timeElapsed() > 500){
                backUp = true;
                mecanumDrivetrain.stop();
            }
            mecanumDrivetrain.goForward(.3f);
        }

        if (!aligned && backUp){
            ArrayList<Float> values = at.getPivotPowers(instruments.yaw);
            if (values.get(0) == 0.0 && values.get(1) == 0.0) {
                mecanumDrivetrain.stop();
                aligned = true;
            }
            mecanumDrivetrain.drive(values.get(0), values.get(1));
            return false;
        }

        if (aligned){
            mecanumDrivetrain.driveSideways(s);
            if (ld.centeredAtLine(instruments.light1, instruments.light2)){
                mecanumDrivetrain.stop();
                return true;
            }
        }

        return false;
    }
}
