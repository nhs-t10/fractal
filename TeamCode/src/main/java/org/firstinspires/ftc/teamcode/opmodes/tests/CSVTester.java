package org.firstinspires.ftc.teamcode.opmodes.tests;

/**
 * Created by robotics on 1/31/17.
 */
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.debug.DataPlot;
import org.firstinspires.ftc.teamcode.opmodes.T10Opmode;

@TeleOp(name="CSV", group="Testers")
public class CSVTester extends T10Opmode {
    DataPlot dp;

    @Override
    public void run() {
        dp = new DataPlot();
    }

    @Override
    public void tick() {
        dp.logData(1, 1);
        dp.getData(1);
    }
}
