package org.firstinspires.ftc.teamcode.debug;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.neurons.Time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    @Deprecated
    private static void renderLines() {
        for(int i=0; i<lines.size(); i++) {
            telemetry.addData(Integer.toString(i), lines.get(i));
        }
        telemetry.update();
    }

    public static void logLine(int contents) { logLine("" + contents, 1); }

    public static void logLine(double contents) { logLine("" + contents, 1); }

    public static void logLine(float contents) { logLine("" + contents, 1); }

    public static void logLine(String contents) {
        logLine(contents, 1);
    }

    public static void logLine(String contents, int priority) {
        if(priority <= mode) {
            /*lines.remove(0);
            lines.add(contents);
            renderLines();*/
//            telemetry.addLine(contents);
        }
    }


    /**
     * Print an entire list as a replacable log
     * @param contents Arraylist of strings to log
     */
    public static void logLines(ArrayList<String> contents) {
        for(String str: contents) {
            logLine(str);
        }
    }

    public static void addData(String key, String value) {
        telemetry.addData(key, value);
    }

    @Deprecated
    public static void clear() {
        for(int i=0; i<lines.size(); i++) {
            lines.set(i, "");
        }
        renderLines();
    }

    private static Map<String, DataPlot> plotMap = new HashMap<String, DataPlot>();

    public static void logFile(String key, String str) {
        if(!plotMap.containsKey(key)) {
            plotMap.put(key, new DataPlot(key));
        }

        plotMap.get(key).logDataRaw(str);
    }

    public static boolean test() {
        logLine("hello");
        Time.sleep(1000);
        logLine("my");
        Time.sleep(1000);
        logLine("name");
        Time.sleep(1000);
        logLine("is");
        Time.sleep(1000);
        logLine("logger");
        return true;
    }
}
