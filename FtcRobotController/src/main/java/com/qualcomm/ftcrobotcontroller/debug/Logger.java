package com.qualcomm.ftcrobotcontroller.debug;

import com.qualcomm.ftcrobotcontroller.lib.Sleep;
import com.qualcomm.robotcore.robocol.Telemetry;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by max on 4/17/16.
 */
public class Logger {
    private static Telemetry telemetry;
    private static ArrayList<String> lines = new ArrayList<String>(Arrays.asList("", "", "", "", ""));
    private static int mode = 1;

    public static void init(Telemetry t) {
        telemetry = t;
    }

    public static void setMode(int m) {
        mode = m;
    }

    private static void renderLines() {
        for(int i=0; i<lines.size(); i++) {
            telemetry.addData(Integer.toString(i), lines.get(i));
        }
    }

    public static void logLine(String contents) {
        logLine(contents, 1);
    }

    public static void logLine(String contents, int priority) {
        if(priority <= mode) {
            lines.remove(0);
            lines.add(contents);
            renderLines();
        }
    }

    public static void clear() {
        for(int i=0; i<lines.size(); i++) {
            lines.set(i, "");
        }
        renderLines();
    }

    public static String test() {
        logLine("hello");
        Sleep.secs(1);
        logLine("my");
        Sleep.secs(1);
        logLine("name");
        Sleep.secs(1);
        logLine("is");
        Sleep.secs(1);
        logLine("logger");
        return "Logger success";
    }
}
