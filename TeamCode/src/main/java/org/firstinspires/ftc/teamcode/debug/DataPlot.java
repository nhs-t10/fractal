package org.firstinspires.ftc.teamcode.debug;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by robotics on 1/26/17.
 */
public class DataPlot {
    private static final String FILE_NAME = "robot_log";
    private static final String EXTENSION = ".csv";
    private static final File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);

    private File f;

    public DataPlot() {
        f = new File(path, FILE_NAME + EXTENSION);

        try {
            f.createNewFile();
        } catch (IOException io) {
            io.printStackTrace();
        }

        writeLine("x,y");
    }

    public void logData(double x, double y) {

    }

    private void writeLine(String text) {
        try {
            FileOutputStream fos = new FileOutputStream(f);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            writer.append(text);
            writer.close();
            fos.flush();
            fos.close();
        } catch(IOException io) {
            io.printStackTrace();
        }
    }
}
