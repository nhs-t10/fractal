package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.controllers.teleop.TestSelect;
import com.qualcomm.ftcrobotcontroller.debug.Component;
import com.qualcomm.ftcrobotcontroller.debug.Logger;
import com.qualcomm.ftcrobotcontroller.organs.QuadDrivetrain;
import com.qualcomm.ftcrobotcontroller.statics.Hardware;
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
