package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.controllers.teleop.FlickerControl;
import org.firstinspires.ftc.teamcode.controllers.teleop.MishaButtonPusher;
import org.firstinspires.ftc.teamcode.controllers.teleop.OneStickMecanum;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.opmodes.T10Opmode;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TIMU;

/**
 * Created by nhs on 9/29/16.
 */

@TeleOp(name="Misha Pusher", group="Testers")
public class MishaPusher extends T10Opmode {
    OneStickMecanum osm;

    MishaButtonPusher mbp;

    public void run() {
        osm = new OneStickMecanum();
        mbp = new MishaButtonPusher();
    }

    public void tick() {
        osm.tick();
        mbp.tick();
    }
}
