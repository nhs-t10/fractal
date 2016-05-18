package com.qualcomm.ftcrobotcontroller.neurons;

import java.util.ArrayList;

/**
 * Created by max on 4/30/16.
 *
 * Yaw-related calculations
 */
public class Cardinal {
    private static double scaleToAngle(double val) { //make values over/under 0-360 normalized
        double scaledVal = val;
        while(scaledVal >= 360) {
            scaledVal -= 360;
        }
        while(scaledVal < 0) {
            scaledVal += 360;
        }

        return scaledVal;
    }

    public static double addAngle(double a, double b) { //angle-safe arithmetic -- (300, 90) gives 30
        return scaleToAngle(a + b);
    }
    public static ArrayList<Float> AngleToDirection(double currentYaw, double destYaw) { //overriding
        return AngleToDirection(currentYaw, destYaw, 7);
    }
    public static ArrayList<Float> AngleToDirection(double currentYaw, double destYaw, int precision) { //Gives motor instructions for a current and dest yaw
        ArrayList<Float> directions = new ArrayList<Float>();

        float driveSpeed = 0.2f;

        if((currentYaw > scaleToAngle(destYaw - precision)) && currentYaw < scaleToAngle(destYaw + precision)) { //if done, make 0. Check for this in your controller!
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
