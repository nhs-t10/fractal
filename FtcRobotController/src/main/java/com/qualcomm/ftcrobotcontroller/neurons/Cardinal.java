package com.qualcomm.ftcrobotcontroller.neurons;

import java.util.ArrayList;

/**
 * Created by max on 4/30/16.
 *
 * IMU related activities
 */
public class Cardinal {
    private static double scaleToAngle(double val) {
        double scaledVal = val;
        while(scaledVal >= 360) {
            scaledVal-=360;
        }
        while(scaledVal < 0) {
            scaledVal+=360;
        }

        return scaledVal;
    }

    public static double addAngle(double a, double b) {
        return scaleToAngle(a + b);
    }
    public static ArrayList<Float> AngleToDirection(double currentYaw, double destYaw) {
        return AngleToDirection(currentYaw, destYaw, 5);
    }
    public static ArrayList<Float> AngleToDirection(double currentYaw, double destYaw, int precision) {
        ArrayList<Float> directions = new ArrayList<Float>();

        float driveSpeed = 0.5f;

        if((currentYaw > scaleToAngle(destYaw - precision)) && currentYaw < scaleToAngle(destYaw + precision)) {
            directions.add(0f);
            directions.add(0f);
        }
        else {
            int direction = ((currentYaw < scaleToAngle(destYaw - precision)) ? 1 : -1);
            directions.add(driveSpeed * direction);
            directions.add(driveSpeed * -direction);
        }

        return directions;
    }
}
