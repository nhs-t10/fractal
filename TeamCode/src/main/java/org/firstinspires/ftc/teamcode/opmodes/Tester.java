package org.firstinspires.ftc.teamcode.opmodes;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.organs.drivetrains.QuadDrivetrain;
import org.firstinspires.ftc.teamcode.statics.Hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.util.ArrayList;

/**
 * Created by max on 5/5/16.
 * Tests organs/tissues sequentially and indicates their success
 */
@TeleOp(name="Linear Tester", group="Testers")
public class Tester extends LinearOpMode {
    private void testComponent(Component c) {
        try {
            Boolean success = c.test();
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

        ArrayList<Component> tests = new ArrayList<Component>();
        tests.add(new QuadDrivetrain());

        for(int i=0; i<tests.size(); i++) {
            testComponent(tests.get(i));
        }
    }
}
