package org.firstinspires.ftc.teamcode.neurons;

/**
 * Created by nhs on 10/25/16.
 */

public class DebouncingButton {
    boolean debounce = false;
    public boolean getToggle(boolean status) {
        if(!debounce && status) {
            debounce = true;
        }
        else if(!status) {
            debounce = false;
        }
        return debounce;
    }
}
