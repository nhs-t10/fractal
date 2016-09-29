package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.controllers.teleop.FlickerControl;
import org.firstinspires.ftc.teamcode.controllers.teleop.OneStickMecanum;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.opmodes.T10Opmode;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TIMU;

/**
 * Created by will on 9/20/16.
 */

@TeleOp(name="Mecanum Tester", group="Testers")
public class MecaIMUTest extends T10Opmode {
    OneStickMecanum osm;
    FlickerControl fc;

    public void run() {
        osm = new OneStickMecanum();
        fc = new FlickerControl();
    }

    public void tick() {
        osm.tick();
        fc.tick();
    }
}
