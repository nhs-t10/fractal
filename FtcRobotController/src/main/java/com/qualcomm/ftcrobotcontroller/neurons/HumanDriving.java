package com.qualcomm.ftcrobotcontroller.neurons;

import com.qualcomm.robotcore.util.Range;

import java.util.ArrayList;

/**
 * Created by max on 4/17/16.
 */
public class HumanDriving {
    private static double scaleInput(double dVal) {
     /*
      * This method scales the joystick input so for low joystick values, the
      * scaled value is less than linear.  This is to make it easier to drive
      * the robot more precisely at slower speeds.
      */

        double[] scaleArray = {0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
                0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00};

        // get the corresponding index for the scaleInput array.
        int index = (int) (dVal * 16.0);

        // index should be positive.
        index = Math.abs(index);

        // index cannot exceed size of array minus 1.
        if (index > 16) {
            index = 16;
        }

        // get value from the array.
        double dScale = 0.0;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }

        // return scaled value.
        return dScale;
    }
    public static ArrayList<Float> JoyToDirection(ArrayList<Float> joyValues) {
        ArrayList<Float> directions = new ArrayList<Float>();

        Float X = (float) scaleInput(Range.clip(joyValues.get(0), -1, 1));
        Float Y = (float) scaleInput(Range.clip(joyValues.get(1), -1, 1));

        float V = (100 - Math.abs(X)) * (Y / 100) + Y; // R+L
        float W = (100 - Math.abs(Y)) * (X / 100) + X; // R-L

        float right = Range.clip(((V + W) / 2), -1, 1);
        float left = Range.clip(((V - W) / 2), -1, 1);

        directions.add(-left);
        directions.add(-right);

        return directions;
    }
    public static enum Direction {FORWARD, REVERSE, LEFT, RIGHT, NONE};
    public static Direction joyDirection(ArrayList<Float> joyValues) {
        float threshold = 0.2f;
        float x = joyValues.get(0);
        float y = joyValues.get(1);
        if(x > threshold) return Direction.RIGHT;
        else if(0 - threshold > x) return Direction.LEFT;
        else if(y > threshold) return Direction.FORWARD;
        else if(0 - threshold > y) return Direction.REVERSE;
        return Direction.NONE;
    }
}
