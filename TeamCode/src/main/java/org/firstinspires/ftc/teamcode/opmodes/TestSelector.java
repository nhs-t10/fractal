package org.firstinspires.ftc.teamcode.opmodes;

import org.firstinspires.ftc.teamcode.controllers.teleop.TestSelect;
import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.organs.QuadDrivetrain;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import java.util.ArrayList;

/**
 * Created by max on 5/5/16.
 * Tests organs/tissues sequentially and indicates their success
 */
public class TestSelector extends T10Opmode {
    private TestSelect testSelect;
    public void run() {
        ArrayList<Component> tests = new ArrayList<Component>();
        TestSelect testSelect = new TestSelect(tests);
    }
    public void tick() {
        testSelect.tick();
    }
}
