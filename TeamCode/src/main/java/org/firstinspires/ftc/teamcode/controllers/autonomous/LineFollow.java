package org.firstinspires.ftc.teamcode.controllers.autonomous;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.neurons.LineAlignment;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by max on 11/26/16.
 */
public class LineFollow implements Controller {
    private DriveTrain driveTrain;
    private Instruments instruments;
    private LineAlignment lineAlignment;
    public LineFollow (Instruments i, DriveTrain d, LineAlignment l) {
        instruments = i;
        driveTrain = d;
        lineAlignment = l;
    }
    public boolean tick() {
        ArrayList<Float> powers = lineAlignment.getPivotPowers(instruments.light1, instruments.light2);
        driveTrain.drive(powers.get(0), powers.get(1));
        return false;
    }
}
