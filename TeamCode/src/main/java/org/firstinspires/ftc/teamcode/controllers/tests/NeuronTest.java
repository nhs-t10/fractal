package org.firstinspires.ftc.teamcode.controllers.tests;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
import org.firstinspires.ftc.teamcode.neurons.LineAlignment;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.tissues.TCamera;

/**
 * Created by nhs on 10/27/16.
 */

public class NeuronTest implements Controller {
    private Instruments instruments;
    private TCamera camera;
    private AngleTurning angleTurning;
    private LineAlignment li;
    public NeuronTest(Instruments i, TCamera c) {
        camera = new TCamera();
        li = new LineAlignment();
        instruments = i;
    }
    public boolean tick() {
        li.getPivotPowers(instruments.light1, instruments.light2);
        return false;
    }
}
