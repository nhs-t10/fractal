package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.Time;
import org.firstinspires.ftc.teamcode.statics.ControlParser;
import org.firstinspires.ftc.teamcode.statics.Controls;
import org.firstinspires.ftc.teamcode.statics.Hardware;

/**
 * Created by Admin on 4/19/2016.
 * Generic ticking opmode
 */
public abstract class T10Opmode extends OpMode {
    private Time.Stopwatch stopwatch;
    public final void init() {
        this.msStuckDetectInit = 600000;
//        this.msStuckDetectLoop = 600000;
        this.msStuckDetectInitLoop = 300000;
        initStatics();
        Logger.logLine("Initializing...");
        stopwatch.start();
        run();
    }

    public final void initStatics() {
        Hardware.init(hardwareMap);
        ControlParser.init(gamepad1, gamepad2, Controls.Shift);
        Logger.init(telemetry);
    }

    public final void loop() {
        Logger.logFile("time", "" + stopwatch.timeElapsed());
        tick();
    }

    /**
     * A method called after waitForStart().
     */
    public abstract void run();

    /**
     * Method that is called every time the loop iterates.
     */
    public abstract void tick();
}
