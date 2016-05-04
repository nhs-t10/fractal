package com.qualcomm.ftcrobotcontroller.controllers;

import com.qualcomm.ftcrobotcontroller.neurons.Cardinal;
import com.qualcomm.ftcrobotcontroller.organs.DriveTrain;
import com.qualcomm.ftcrobotcontroller.organs.Instruments;
import com.qualcomm.ftcrobotcontroller.statics.Hardware;
import com.qualcomm.ftcrobotcontroller.tissues.TIMU;

import java.util.ArrayList;

/**
 * Created by Admin on 5/3/2016.
 */
public class Turn implements Controller {
    private Instruments ins;
    private DriveTrain dt;

    private double degrees;

    public Turn(DriveTrain dt, Instruments ins) {
        this.dt = dt;
        this.ins = ins;

        degrees = 90;
    }

    public void setDeg(double deg) {
        degrees = deg;
    }

    public boolean tick() {
        ArrayList<Float> dirs = Cardinal.AngleToDirection(ins.yaw, Cardinal.addAngle(ins.yaw, degrees));
        dt.drive(dirs.get(0), dirs.get(1));
        return (dirs.get(0) == 0f && dirs.get(1) == 0.0f);
    }
}
