package org.firstinspires.ftc.teamcode.controllers.tests;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
import org.firstinspires.ftc.teamcode.neurons.LineAlignment;
import org.firstinspires.ftc.teamcode.neurons.LineDetection;
import org.firstinspires.ftc.teamcode.neurons.LinearizedDistance;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TCamera;

//import org.firstinspires.ftc.teamcode.neurons.BeaconCheck;

/**
 * Created by nhs on 10/27/16.
 */

public class NeuronTest implements Controller {
    private Instruments instruments;
    private TCamera camera;
    private AngleTurning angleTurning;
    private LineAlignment li = new LineAlignment(10f);
    private LineDetection ld = new LineDetection();
//    private BeaconCheck bc;
    private boolean pressed = false;
    public NeuronTest(Instruments i,
                      TCamera c
    ) {
        camera = c;
        instruments = i;
//        bc = new BeaconCheck(Team.RED);
    }
    public boolean tick() {
        Logger.logLine("distance: " + instruments.distance);
        Logger.logLine("yaw: " + instruments.yaw);
        Logger.logLine("IR Distance: " + instruments.IRdistance);
//        Logger.logLine("IR Distance Linearized: " + LinearizedDistance.linearize((instruments.IRdistance)));
//        bc.update(camera.getAnalysis());
        Logger.logLine("Light 1: " + instruments.light1);
        Logger.logLine("Light 2:" + instruments.light2);
        Logger.logLine("Centered at line: " + ld.centeredAtLine(instruments.light1, instruments.light2));
        Logger.logLine(camera.getString());
//        if(!pressed) pressed = bc.isPressed();
        Logger.logLine("pressed: " + pressed);
//        Logger.logLine("Voltage: " + Hardware.getVoltage());
//        ld.isAtLine(instruments.light1, instruments.light2);
        return false;
    }
}
