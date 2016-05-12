package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.debug.Component;
import com.qualcomm.ftcrobotcontroller.debug.Logger;
import com.qualcomm.ftcrobotcontroller.organs.Instruments;
import com.qualcomm.ftcrobotcontroller.organs.QuadDrivetrain;
import com.qualcomm.ftcrobotcontroller.organs.TreadDrivetrain;
import com.qualcomm.ftcrobotcontroller.statics.Hardware;
import com.qualcomm.ftcrobotcontroller.tissues.TIMU;
import com.qualcomm.ftcrobotcontroller.tissues.TMotor;
import com.qualcomm.ftcrobotcontroller.tissues.TServo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import java.util.ArrayList;

/**
 * Created by max on 5/5/16.
 */
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
        //tests.add(new Instruments());
    }
}
