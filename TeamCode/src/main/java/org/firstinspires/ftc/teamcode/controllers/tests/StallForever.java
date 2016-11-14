package org.firstinspires.ftc.teamcode.controllers.tests;

import org.firstinspires.ftc.teamcode.controllers.Controller;

/**
 * Created by robotics on 11/14/16.
 */
public class StallForever implements Controller {
    @Override
    public boolean tick() {
        return false;
    }
}
