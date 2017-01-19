package org.firstinspires.ftc.teamcode.neurons;

/**
 * Created by Jack on 1/19/2017.
 */

public class LinearizedDistance {
    public static double linearize(double d) {
        if (d == 3) d = 2.99;
        return (double) 6787/(d - 3) - 4;
    }
}
