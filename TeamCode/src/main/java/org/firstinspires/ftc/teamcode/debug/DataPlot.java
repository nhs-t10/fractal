package org.firstinspires.ftc.teamcode.debug;

import android.os.Environment;

import org.firstinspires.ftc.teamcode.lib.T10FileWrapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by robotics on 1/26/17.
 */
public class DataPlot {
    private static final String FILE_NAME = "robot_log.csv";
    private static final String PATH = "/sdcard/FIRST/log/";

    private T10FileWrapper f;

    public DataPlot() {
        f = new T10FileWrapper(PATH, FILE_NAME);
    }

    public void logData(double x, double y) {
        f.write("" + x +", " + y);
    }

    public void getData(int line) {
        Logger.logLine(f.getLine(line));
    }
}