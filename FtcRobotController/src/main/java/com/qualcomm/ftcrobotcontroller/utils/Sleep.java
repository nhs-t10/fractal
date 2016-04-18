package com.qualcomm.ftcrobotcontroller.utils;

/**
 * Created by max on 4/17/16.
 */
public class Sleep {
    private static void sleep(long length) {
        try {
            Thread.sleep(length);
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
    public static void secs(double length) {
        sleep((long) length * 1000);
    }
    public static void ms(int length) {
        sleep((long) length);
    }
}
