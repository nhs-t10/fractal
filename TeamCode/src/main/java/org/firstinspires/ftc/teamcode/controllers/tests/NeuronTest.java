package org.firstinspires.ftc.teamcode.controllers.tests;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
import org.firstinspires.ftc.teamcode.neurons.LineAlignment;
import org.firstinspires.ftc.teamcode.neurons.LineDetection;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.tissues.TCamera;

/**
 * Created by nhs on 10/27/16.
 */

public class NeuronTest implements Controller {
    private Instruments instruments;
    private TCamera camera;
    private AngleTurning angleTurning;
    private LineAlignment li = new LineAlignment(10f);
    private LineDetection ld = new LineDetection();
    public NeuronTest(Instruments i, TCamera c) {
        camera = c;
        instruments = i;
    }
    public boolean tick() {
        Logger.logLine("distance: " + instruments.distance);
        Logger.logLine("yaw: " + instruments.yaw);
        Logger.logLine(camera.getString());
        ld.isAtLine(instruments.light1, instruments.light2);
        return false;
    }
}
