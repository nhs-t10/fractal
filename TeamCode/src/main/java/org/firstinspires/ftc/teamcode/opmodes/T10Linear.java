package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.statics.ControlParser;
import org.firstinspires.ftc.teamcode.statics.Controls;
import org.firstinspires.ftc.teamcode.statics.Hardware;

import java.util.ArrayList;

/**
 * Created by Admin on 4/19/2016.
 *
 * Sequential autonomous controller-ticker
 */
public abstract class T10Linear extends OpMode {
    private ArrayList<Controller> queue = new ArrayList<Controller>(); //must be fixed so we can call .tick() on any static controller

    private int index = 0;

    public final void init() {
        initStatics();
        Logger.logLine("Initializing... CCC");
        registration();
    }

    public final void initStatics() {
        Hardware.init(hardwareMap);
        ControlParser.init(gamepad1, gamepad2, Controls.Shift);
        Logger.init(telemetry);
    }

    public final void loop() {
        if(index < queue.size()) {
            boolean complete = queue.get(index).tick();

            if(complete) {
                Logger.logLine("Task complete: " + index);
                index++;
            }
        }
    }

    /**
    * Called by the child to register a controller into the queueing system
    */
    public final void registerController(Controller ctrl) {
        queue.add(ctrl);
    }

    /**
     * A place for autonomous opmodes to register their controllers
     */
    public abstract void registration();
}
