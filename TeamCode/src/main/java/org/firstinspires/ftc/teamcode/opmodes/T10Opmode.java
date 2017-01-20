package org.firstinspires.ftc.teamcode.opmodes;

import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.statics.ControlParser;
import org.firstinspires.ftc.teamcode.statics.Controls;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by Admin on 4/19/2016.
 * Generic ticking opmode
 */
public abstract class T10Opmode extends OpMode {
    public final void init() {
        this.msStuckDetectInit = 10000;
        initStatics();
        Logger.logLine("Initializing...");
        run();
    }

    public final void initStatics() {
        Hardware.init(hardwareMap);
        ControlParser.init(gamepad1, gamepad2, Controls.Shift);
        Logger.init(telemetry);
    }

    public final void loop() {
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
