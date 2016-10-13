package org.firstinspires.ftc.teamcode.statics;

import org.firstinspires.ftc.teamcode.debug.Logger;
import com.qualcomm.robotcore.exception.RobotCoreException;
import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static void init(Gamepad g1, Gamepad g2, String s) {
        gamepad1 = g1;
        gamepad2 = g2;
        shift = s;
    }
    private static boolean getButtonResult(int gamepadid, String control) {
        boolean result = false;

        Gamepad gamepad;

        gamepad = (gamepadid == 1 ? gamepad1 : gamepad2);

        if(control.equals("A")) {
            result = gamepad.a;
        }
        else if(control.equals("B")) {
            result = gamepad.b;
        }
        else if(control.equals("X")) {
            result = gamepad.x;
        }
        else if(control.equals("Y")) {
            result = gamepad.y;
        }
        else if(control.equals("DD")) {
            result = gamepad.dpad_down;
        }
        else if(control.equals("DL")) {
            result = gamepad.dpad_left;
        }
        else if(control.equals("DR")) {
            result = gamepad.dpad_right;
        }
        else if(control.equals("DU")) {
            result = gamepad.dpad_up;
        }
        else if(control.equals("LB")) {
            result = gamepad.left_bumper;
        }
        else if(control.equals("RB")) {
            result = gamepad.right_bumper;
        }
        else if(control.equals("RSB")) {
            result = gamepad.right_stick_button;
        }
        else if(control.equals("LSB")) {
            result = gamepad.left_stick_button;
        }
        else {
            Logger.logLine("No valid control specified (" + control + ")", 1);
            result = false;
        }

        return result;
    }
    private static ArrayList<Float> getRangeResult(int gamepadid, String control) {
        ArrayList<Float> results = new ArrayList<Float>();

        Gamepad gamepad;

        gamepad = (gamepadid == 1 ? gamepad1 : gamepad2);

        if(control.equals("LT")) {
            results.add(gamepad.left_trigger);
        }
        else if(control.equals("RT")) {
            results.add(gamepad.right_trigger);
        }
        else if(control.equals("RS")) {
            results.add(gamepad.right_stick_x);
            results.add(gamepad.right_stick_y);
        }
        else if(control.equals("LS")) {
            results.add(gamepad.left_stick_x);
            results.add(gamepad.left_stick_y);
        }
        else {
            Logger.logLine("No valid control specified (" + control + ")", 1);
        }

        return results;
    }
    private static int parseGamepad(String gnum){
        int gamepad = (gnum.equals("2") ? 2 : 1);
        if(!gnum.equals("2") && !gnum.equals("1")) Logger.logLine("Warning: No controller # specified in query. Defaulting to 1.", 1);
        return gamepad;
    }

    public static ArrayList<Float> range(String controlString) { //"LS1"
        ArrayList<Float> results = new ArrayList<Float>();
        List<String> query = new ArrayList<String>(Arrays.asList(controlString.split(""))); //["L", "S", "1"]
        String gnum = query.get(query.size() - 1); //"1"
        query.remove(query.size() - 1); //["L", "S"]

        int gamepad = parseGamepad(gnum);
        boolean shiftCheck = (query.get(0).equals("^"));
        if(shiftCheck) query.remove(0); //["L", "S"]

        String control = "";
        for(int i=0; i<query.size(); i++) { //"LS"
            control += query.get(i);
        }

        results.addAll(getRangeResult(gamepad, control)); //[true, true]

        return results;
    }

    public static boolean button(String controlString) { //"^A1"
        List<String> query = new ArrayList<String>(Arrays.asList(controlString.split(""))); //["^", "A", "1"]
        String gnum = query.get(query.size() - 1); //"1"
        query.remove(query.size() - 1); //["^", "A"]

        int gamepad = parseGamepad(gnum);
        boolean shiftCheck = (query.get(0).equals("^"));
        Logger.logLine("Shifts " + query.get(0) + " " + query.toString());
        if(shiftCheck) query.remove(0); //["A"]

        String control = "";
        for(int i=0; i<query.size(); i++) { //"A"
            control += query.get(i);
        }

        boolean results = (shiftCheck
        ? getButtonResult(gamepad, shift) && getButtonResult(gamepad, control)
        : !getButtonResult(gamepad, shift) && getButtonResult(gamepad, control));

        return results;
    }
}
