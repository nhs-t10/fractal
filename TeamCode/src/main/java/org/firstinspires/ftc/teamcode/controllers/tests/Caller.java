package org.firstinspires.ftc.teamcode.controllers.tests;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.autonomous.PorpotionalTuning;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.AngleTurning;
import org.firstinspires.ftc.teamcode.neurons.Time;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;
import org.firstinspires.ftc.teamcode.statics.ControlParser;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by jacob_000 on 11/25/2016.
 */

public class Caller implements Controller{
    private int count;
    private int toCall = 0;
    private ArrayList calling;
    private ArrayList names;
    public Caller(ArrayList values, ArrayList titles) {
        count = Array.getLength(calling);
        names = titles;
        calling = values;
    }
    public boolean tick() {
        if (toCall == count){
            return false;
        }
        else Logger.logLine(names.get(toCall) + ": " + calling.get(toCall));
        return false;
    }
}
