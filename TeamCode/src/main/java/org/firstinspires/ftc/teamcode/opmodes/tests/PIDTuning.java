package org.firstinspires.ftc.teamcode.opmodes.tests;

import org.firstinspires.ftc.teamcode.controllers.autonomous.IntegralTuning;
import org.firstinspires.ftc.teamcode.controllers.autonomous.PorpotionalTuning;
import org.firstinspires.ftc.teamcode.controllers.autonomous.ZieglerNichols;
import org.firstinspires.ftc.teamcode.opmodes.T10Autonomous;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.tissues.TCamera;

/**
 * Created by jacob_000 on 11/24/2016.
 */

public class PIDTuning extends T10Autonomous{
    private TCamera camera;
    public void tuning() {
        MecanumDrivetrain md = new MecanumDrivetrain();
        Instruments instruments = new Instruments();
        PorpotionalTuning pt = new PorpotionalTuning(instruments, md);
        IntegralTuning it = new IntegralTuning(instruments, md, pt);
        instruments.start();
        registerController(pt);
        registerController(new ZieglerNichols(instruments, md, pt));
        registerController(it);

    }
}
