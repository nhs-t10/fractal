package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.debug.Logger;
import com.qualcomm.ftcrobotcontroller.statics.ControlParser;
import com.qualcomm.ftcrobotcontroller.statics.Controls;
import com.qualcomm.ftcrobotcontroller.statics.Hardware;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by Admin on 4/19/2016.
 */
public abstract class T10Opmode extends OpMode {
    public final void init() {
        initStatics();
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
     * A methcd called after waitForStart().
     */
    public abstract void run();

    /**
     * Method that is called every time the loop iterates.
     */
    public abstract void tick();
}
