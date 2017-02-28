package org.firstinspires.ftc.teamcode.neurons;

import java.util.ArrayList;

/**
 * Created by max on 2/11/17.
 * Life is a void. one in which everything is bleak and depressing. There is no escape. No escape from the clutches of the spaghetti monster. The monster that has taken the world and rules it from the shadow. The president. The Project Manager. The Prime Minister. The Dictators of China and Russia. Thus Humanity is in its worst hour. MAy this hour become short and less painful for its victims.
 */
public class JoyDegrees {
    public static double toDeg(ArrayList<Float> coords) {
        return Math.toDegrees(Math.atan2(coords.get(1), coords.get(0))) + 90;
    }
}
