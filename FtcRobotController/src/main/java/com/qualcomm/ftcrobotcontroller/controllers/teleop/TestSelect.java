package com.qualcomm.ftcrobotcontroller.controllers.teleop;

import com.qualcomm.ftcrobotcontroller.controllers.Controller;
import com.qualcomm.ftcrobotcontroller.debug.Component;
import com.qualcomm.ftcrobotcontroller.debug.Logger;
import com.qualcomm.ftcrobotcontroller.neurons.HumanDriving;
import com.qualcomm.ftcrobotcontroller.statics.ControlParser;
import com.qualcomm.ftcrobotcontroller.statics.Controls;

import java.util.ArrayList;

/**
 * Created by robotics on 6/9/16.
 */
public class TestSelect implements Controller {
    private ArrayList<String> menu = new ArrayList<String>();
    private ArrayList<Component> tests = new ArrayList<Component>();

    private int index = 0;
    private boolean testing = false;

    public TestSelect(ArrayList<Component> t) {
        tests = t;
    }

    private void testComponent(Component c) {
        testing = true;
        try {
            Boolean success = c.test();
            testing = false;
        }
        catch(Error error) {
            Logger.logLine("[×] " + c.getName() + " " + error.toString());
        }
    }

    public void render() {
        menu.clear();
        menu.add("Select a test:");
        for(int i=0; i<tests.size(); i++) {
            if(index == i && testing) menu.add("● " + tests.get(i).getName());
            else if(index == i && !testing) menu.add("> " + tests.get(i).getName());
            else menu.add(tests.get(i).getName());
        }
        Logger.logLines(menu);
    }

    private void increment(int dir) {
        if(index == 0 && (dir < 0)) index = tests.size() - 1;
        else if(index == tests.size() - 1 && dir > 0) index = 0;
        else index += dir;
    }

    public boolean tick() {
        ArrayList<Float> joyValues = ControlParser.range(Controls.Selector);
        HumanDriving.Direction direction = HumanDriving.joyDirection(joyValues);

        if(direction == HumanDriving.Direction.FORWARD) increment(1);
        else if(direction == HumanDriving.Direction.REVERSE) increment(-1);

        if(ControlParser.button("A1")) testComponent(tests.get(index));

        render();

        return false;
    }
}
