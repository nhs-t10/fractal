package com.qualcomm.ftcrobotcontroller.statics;

import com.qualcomm.ftcrobotcontroller.debug.Logger;
import com.qualcomm.ftcrobotcontroller.lib.Pair;
import com.qualcomm.robotcore.hardware.Gamepad;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by max on 4/17/16.
 */

/*
* ControlParser.range(String controlString) for float-y controls
* ControlParser.button(String controlString) for bool-y controls
* */
public class ControlParser {
    private static Gamepad gamepad1;
    private static Gamepad gamepad2;
    private static String shift;

    private static final Map<String, Pair<?, ?>> ControlMap;
    static {
        ControlMap = new HashMap<String, Pair<?, ?>>();
        //Boolean control maps
        ControlMap.put("A", Pair.of(gamepad1.a, gamepad2.a));
        ControlMap.put("B", Pair.of(gamepad1.b, gamepad2.b));
        ControlMap.put("X", Pair.of(gamepad1.x, gamepad2.x));
        ControlMap.put("Y", Pair.of(gamepad1.y, gamepad2.y));
        ControlMap.put("DD", Pair.of(gamepad1.dpad_down, gamepad2.dpad_down));
        ControlMap.put("DL", Pair.of(gamepad1.dpad_left, gamepad2.dpad_up));
        ControlMap.put("DR", Pair.of(gamepad1.dpad_right, gamepad2.dpad_right));
        ControlMap.put("DU", Pair.of(gamepad1.dpad_up, gamepad2.dpad_up));
        ControlMap.put("LB", Pair.of(gamepad1.left_bumper, gamepad2.left_bumper));
        ControlMap.put("RB", Pair.of(gamepad1.right_bumper, gamepad2.right_bumper));
        ControlMap.put("LSB", Pair.of(gamepad1.left_stick_button, gamepad2.left_stick_button));
        ControlMap.put("RSB", Pair.of(gamepad1.right_stick_button, gamepad2.right_stick_button));
        //Floating pointer control maps
        ControlMap.put("LT", Pair.of(gamepad1.left_trigger, gamepad2.left_trigger));
        ControlMap.put("RT", Pair.of(gamepad1.right_trigger, gamepad2.right_trigger));
        ControlMap.put("LS", Pair.of(Pair.of(gamepad1.left_stick_x, gamepad1.left_stick_y), Pair.of(gamepad2.left_stick_x, gamepad2.left_stick_y)));
        ControlMap.put("RS", Pair.of(Pair.of(gamepad1.right_stick_x, gamepad1.right_stick_y), Pair.of(gamepad2.right_stick_x, gamepad2.right_stick_y)));
    }

    public static void init(Gamepad g1, Gamepad g2, String s) {
        gamepad1 = g1;
        gamepad2 = g2;
        shift = s;
    }

    private static ArrayList<Boolean> getButtonResult(int gamepadId, String control) {
        ArrayList<Boolean> results = new ArrayList<Boolean>();
        Object value = null;

        if(gamepadId == 1) {
            value = ControlMap.get(control).first;
        } else if(gamepadId == 2) {
            value = ControlMap.get(control).second;
        }

        if(value instanceof Boolean) {
            results.add((Boolean)value);
        } else {
            throw new Error("No valid control specified.");
        }

        return results;
    }
    private static ArrayList<Float> getRangeResult(int gamepadId, String control) {
        ArrayList<Float> results = new ArrayList<Float>();
        Object value = null;

        if(gamepadId == 1) {
            value = ControlMap.get(control).first;
        } else if(gamepadId == 2) {
            value = ControlMap.get(control).second;
        }

        if(value instanceof Float) {
            results.add((Float)value);
        } else if(value instanceof Pair) {
            results.add((Float)((Pair) value).first);
            results.add((Float)((Pair) value).second);
        } else {
            throw new Error("No valid control specified.");
        }

        return results;
    }

    public static ArrayList<Float> range(String controlString) { //"LS1"
        ArrayList<Float> results = new ArrayList<Float>();
        List<String> query = Arrays.asList(controlString.split("")); //["L", "S", "1"]
        String gnum = query.get(query.size() - 1); //"1"
        query.remove(gnum); //["L", "S"]

        int gamepad = (gnum.equals("1") ? 1 : 2);
        Boolean shiftCheck = (query.get(0).equals("^"));
        if(shiftCheck) query.remove(query.get(0)); //["L", "S"]

        String control = "";
        for(int i=0; i<query.size(); i++) { //"LS"
            control += query.get(i);
        }

        if(shiftCheck) results.addAll(getRangeResult(gamepad, shift)); //[true]
        results.addAll(getRangeResult(gamepad, control)); //[true, true]

        return results;
    }

    public static ArrayList<Boolean> button(String controlString) { //"^A1"
        ArrayList<Boolean> results = new ArrayList<Boolean>();
        List<String> query = Arrays.asList(controlString.split("")); //["^", "A", "1"]
        String gnum = query.get(query.size() - 1); //"1"
        query.remove(gnum); //["^", "A"]

        int gamepad = (gnum.equals("1") ? 1 : 2);
        boolean shiftCheck = (query.get(0).equals("^"));
        if(shiftCheck) query.remove(query.get(0)); //["A"]

        String control = "";
        for(int i=0; i<query.size(); i++) { //"A"
            control += query.get(i);
        }

        results.addAll(getButtonResult(gamepad, control)); //[true, true]

        return results;
    }
}
