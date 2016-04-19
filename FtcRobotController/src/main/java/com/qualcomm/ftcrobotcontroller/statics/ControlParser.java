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

    private static final Map<String, Field> ControlMap;
    private static Pair<Field, Field> leftStick;
    private static Pair<Field, Field> rightStick;
    static {
        ControlMap = new HashMap<String, Field>();
        try {
            leftStick = Pair.of(Gamepad.class.getField("left_stick_x"), Gamepad.class.getField("left_stick_y"));
            rightStick = Pair.of(Gamepad.class.getField("right_stick_x"), Gamepad.class.getField("right_stick_y"));

            //Boolean control maps
            ControlMap.put("A", Gamepad.class.getField("a"));
            ControlMap.put("B", Gamepad.class.getField("b"));
            ControlMap.put("X", Gamepad.class.getField("x"));
            ControlMap.put("Y", Gamepad.class.getField("y"));
            ControlMap.put("DD", Gamepad.class.getField("dpad_down"));
            ControlMap.put("DL", Gamepad.class.getField("dpad_left"));
            ControlMap.put("DR", Gamepad.class.getField("dpad_right"));
            ControlMap.put("DU", Gamepad.class.getField("dpad_up"));
            ControlMap.put("LB", Gamepad.class.getField("left_bumper"));
            ControlMap.put("RB", Gamepad.class.getField("right_bumper"));
            ControlMap.put("LSB", Gamepad.class.getField("left_stick_button"));
            ControlMap.put("RSB", Gamepad.class.getField("right_stick_button"));
            //Floating pointer control maps
            ControlMap.put("LT", Gamepad.class.getField("left_trigger"));
            ControlMap.put("RT",  Gamepad.class.getField("right_trigger"));
            ControlMap.put("LS", ControlParser.class.getDeclaredField("leftStick"));
            ControlMap.put("RS", ControlParser.class.getDeclaredField("rightStick"));
        } catch(NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void init(Gamepad g1, Gamepad g2, String s) {
        gamepad1 = g1;
        gamepad2 = g2;
        shift = s;
    }

    private static ArrayList<Boolean> getButtonResult(int gamepadId, String control) {
        ArrayList<Boolean> results = new ArrayList<Boolean>();
        Field value = null;
        Gamepad gp = gamepad1;

        if(gamepadId == 1) {
            value = ControlMap.get(control);
            gp = gamepad1;
        } else if(gamepadId == 2) {
            value = ControlMap.get(control);
            gp = gamepad2;
        }

        try {
            if (value != null && value.getGenericType().toString().equals("boolean")) {
                results.add(value.getBoolean(gp));
            } else {
                throw new Error("No valid control specified.");
            }
        } catch(IllegalAccessException e) {
            e.printStackTrace();
        }

        return results;
    }
    private static ArrayList<Float> getRangeResult(int gamepadId, String control) {
        ArrayList<Float> results = new ArrayList<Float>();
        Field value = null;
        Gamepad gp = gamepad1;

        if(gamepadId == 1) {
            value = ControlMap.get(control);
            gp = gamepad1;
        } else if(gamepadId == 2) {
            value = ControlMap.get(control);
            gp = gamepad2;
        }
        
        try {
            if (value != null && value.getGenericType().toString().equals("float")) {
                results.add(value.getFloat(gp));
            } else if(value!= null && value.getGenericType().toString().equals("Pair")) {
                results.add((Float)((Pair)value.get(null)).first);
                results.add((Float)((Pair)value.get(null)).second);
            } else {
                throw new Error("No valid control specified.");
            }
        } catch(IllegalAccessException e) {
            e.printStackTrace();
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
