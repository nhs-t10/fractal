package org.firstinspires.ftc.teamcode.controllers.tests;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
import org.firstinspires.ftc.teamcode.organs.Instruments;

/**
 * Created by nhs on 10/27/16.
 */

public class NeuronTest implements Controller {
    private Instruments instruments;
    private AngleTurning angleTurning;
    public NeuronTest(Instruments i) {
        instruments = i;
        angleTurning = new AngleTurning(200, 0);
    }
    public boolean tick() {
        angleTurning.getPowers(instruments.yaw);
        return false;
    }
}
