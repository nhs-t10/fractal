package org.firstinspires.ftc.teamcode.opmodes.tests;

import org.firstinspires.ftc.teamcode.controllers.autonomous.DerivativeTuning;
import org.firstinspires.ftc.teamcode.controllers.autonomous.IntegralTuning;
import org.firstinspires.ftc.teamcode.controllers.autonomous.PorpotionalTuning;
import org.firstinspires.ftc.teamcode.controllers.autonomous.ZieglerNichols;
import org.firstinspires.ftc.teamcode.controllers.tests.Caller;
import org.firstinspires.ftc.teamcode.opmodes.T10Autonomous;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.tissues.TCamera;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jacob_000 on 11/24/2016.
 */

public class PIDTuning extends T10Autonomous{
    private TCamera camera;
    public void registration() {
        MecanumDrivetrain md = new MecanumDrivetrain();
        Instruments instruments = new Instruments();
        PorpotionalTuning pt = new PorpotionalTuning(instruments, md);
        IntegralTuning it = new IntegralTuning(instruments, md, pt);
        DerivativeTuning dt = new DerivativeTuning(instruments, md, pt, it);
        instruments.start();
        registerController(pt);
        registerController(new ZieglerNichols(instruments, md, pt));
        registerController(it);
        registerController(dt);
        ArrayList<Double> values = new ArrayList<>();
        values.add(pt.KP);
        values.add(it.KI);
        values.add(dt.KD);
        ArrayList<String> names = new ArrayList<String>();
        names.add("KP");
        names.add("KI");
        names.add("KD");
        registerController(new Caller(values, names));
    }
}
