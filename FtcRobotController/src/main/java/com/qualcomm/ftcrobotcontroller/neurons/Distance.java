package com.qualcomm.ftcrobotcontroller.neurons;

/**
 * Created by robotics on 5/3/16.
 */
public class Distance {
    public static final double WALL_DISTANCE = 13.0;

    @Deprecated
    public static boolean isAtWall(double distance) {
        return (distance < 13.0);
    }
}
