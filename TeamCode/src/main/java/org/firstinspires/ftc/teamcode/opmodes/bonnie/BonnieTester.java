package org.firstinspires.ftc.teamcode.opmodes.bonnie;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TMotor;

/**
 * Created by max on 5/5/16.
 * Tests organs/tissues sequentially and indicates their success
 */
@TeleOp(name="Bonnie Tester", group="Bonnie")
public class BonnieTester extends LinearOpMode {
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
        Logger.logLine("Testing motor left front");
        testComponent(new TMotor(Hardware.MotorLeftFront));
        Logger.logLine("Testing motor right front");
        testComponent(new TMotor(Hardware.MotorRightFront));
        Logger.logLine("Testing motor left rear");
        testComponent(new TMotor(Hardware.MotorLeftRear));
        Logger.logLine("Testing motor right rear");
        testComponent(new TMotor(Hardware.MotorRightRear));
        Logger.logLine("Done testing");
//        testComponent(new MecanumDrivetrain());
//        testComponent(new Stopper());
//        testComponent(new Pusher());
//        testComponent(new Flicker(false, -1));
//        testComponent(new Spinner(-1));
//        testComponent(new Spinner(Hardware.LiftSpinner, 1));
    }
}
