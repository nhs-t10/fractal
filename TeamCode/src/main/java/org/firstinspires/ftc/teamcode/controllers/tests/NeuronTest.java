package org.firstinspires.ftc.teamcode.controllers.tests;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.tissues.TCamera;

/**
 * Created by nhs on 10/27/16.
 */

public class NeuronTest implements Controller {
    private Instruments instruments;
    private TCamera camera;
    private AngleTurning angleTurning;
    public NeuronTest(Instruments i, TCamera c) {
        instruments = i;
        camera = c;
    }
    public boolean tick() {
//        angleTurning.getPowers(instruments.yaw);
        Logger.logLine(camera.getString());
        return false;
    }
}
