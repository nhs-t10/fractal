package com.qualcomm.ftcrobotcontroller.controllers;

import com.qualcomm.ftcrobotcontroller.debug.Logger;
import com.qualcomm.ftcrobotcontroller.organs.Instruments;
import com.qualcomm.ftcrobotcontroller.statics.Hardware;

/**
 * Created by Admin on 5/10/2016.
 */
public class TeleSensors implements Controller {
    Instruments i;

    public TeleSensors() {
        i = new Instruments();
        i.start();
    }

    public boolean tick() {
        Logger.logLine("" + i.yaw);
        return false;
    }
}