package org.firstinspires.ftc.teamcode.neurons;

import java.util.ArrayList;

/**
 * Created by max on 2/11/17.
 */
public class JoyDegrees {
    public static double toDeg(ArrayList<Float> coords) {
        return Math.toDegrees(Math.atan2(coords.get(1), coords.get(0))) - 180;
    }
}
