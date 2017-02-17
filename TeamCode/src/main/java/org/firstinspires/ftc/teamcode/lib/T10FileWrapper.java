package org.firstinspires.ftc.teamcode.lib;

import android.os.Environment;

import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.Time;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by robotics on 1/31/17.
 */
public class T10FileWrapper {
    private File file;
    private File pathFile;
    private String path = "/sdcard/";
    private String name;
    private String ext;
    private int num = 1;

    public T10FileWrapper(String path, String name, String ext) {
        pathFile = new File(path);
        if(!pathFile.exists()) {
            pathFile.mkdirs();
        }

        file = new File(path+name+"_"+Time.getDateStr()+ext);

        try {
            file.createNewFile();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void writeLine(String input) {
        write(input + "\n");
    }

    public void write(String input) {
        if(!isExternalStorageWritable()) {
            Logger.logLine("cannot write to " + name);
            return;
        }

        try {
            FileOutputStream fos = new FileOutputStream(file, true);
            fos.write(input.getBytes());
            fos.close();
        } catch(IOException io) {
            io.printStackTrace();
        }
    }

    public String getLine(int num) {
        try {
            return read().get(num - 1);
        } catch (IndexOutOfBoundsException iob) {
            iob.printStackTrace();
            return null;
        }
    }

    private ArrayList<String> read() {
        ArrayList<String> data = new ArrayList<String>();

        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String line;
            while((line = br.readLine()) != null){
                data.add(line);
            }

            br.close();
            isr.close();
            fis.close();
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }


        return data;
    }

    /* Checks if external storage is available for read and write */
    public static boolean isExternalStorageWritable() {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public static boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
}