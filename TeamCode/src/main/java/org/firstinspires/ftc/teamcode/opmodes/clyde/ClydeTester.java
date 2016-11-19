package org.firstinspires.ftc.teamcode.opmodes.clyde;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.organs.Flicker;
import org.firstinspires.ftc.teamcode.organs.Pusher;
import org.firstinspires.ftc.teamcode.organs.Spinner;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.statics.Hardware;

import java.util.ArrayList;

/**
 * Created by max on 5/5/16.
 * Tests organs/tissues sequentially and indicates their success
 */
@TeleOp(name="Clyde Tester", group="Clyde")
public class ClydeTester extends LinearOpMode {
    private void testComponent(Component c) {
        try {
            boolean success = c.test();
            Logger.logLine((success ? "[✓] " : "[×] ") + c.getName());
        }
        catch(Error error) {
            Logger.logLine("[×] " + c.getName() + " " + error.toString());
        }
    }
    @Override
    public void runOpMode() throws InterruptedException {
        Hardware.init(hardwareMap);
        Logger.init(telemetry);
        waitForStart();

        testComponent(new MecanumDrivetrain());
        testComponent(new Spinner());
        testComponent(new Flicker());
        testComponent(new Pusher());
    }
}
