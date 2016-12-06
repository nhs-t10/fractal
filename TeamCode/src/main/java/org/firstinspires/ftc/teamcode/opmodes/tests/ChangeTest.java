package org.firstinspires.ftc.teamcode.opmodes.tests;

import org.firstinspires.ftc.teamcode.controllers.tests.ChangeableVariable;
import org.firstinspires.ftc.teamcode.opmodes.T10Opmode;

/**
 * Created by robotics on 11/18/16.
 */
public class ChangeTest extends T10Opmode {
    ChangeableVariable var;

    @Override
    public void run() {
        ChangeableVariable.Options opt = new ChangeableVariable.Options();
        opt.verbose = true;
        var = new ChangeableVariable("Stuff", 1.0, 1.0, opt);
    }

    @Override
    public void tick() {

    }
}
