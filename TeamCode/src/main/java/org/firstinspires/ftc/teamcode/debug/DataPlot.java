package org.firstinspires.ftc.teamcode.debug;

import org.firstinspires.ftc.teamcode.lib.T10FileWrapper;

/**
 * Created by robotics on 1/26/17.
 */
public class DataPlot {
    private static final String FILE_NAME = "robot_log";
    private static final String FILE_EXTENSION = ".csv";
    private static final String PATH = "/sdcard/FIRST/log/";

    private T10FileWrapper f;

    public DataPlot() {
        f = new T10FileWrapper(PATH, FILE_NAME, FILE_EXTENSION);
        f.writeLine("x,y");
    }

    public void logData(double x, double y) {
        f.writeLine("" + x + "," + y);
    }

    public String getData(int line) {
        return f.getLine(line);
    }
}