package org.firstinspires.ftc.teamcode.neurons;

import org.firstinspires.ftc.teamcode.organs.Instruments;

/**
 * Created by Jacob on 2/1/2017.
 */

public class DeNoiser {
    public double supposedDistance;
    public double changeInDistance = .1;
    public double pastDistance;
    public double realDistance;
    public Instruments instruments;
    public DeNoiser(Instruments i){
        instruments = i;
    }
    public double distance(){
        supposedDistance = instruments.distance;
        if ((supposedDistance >= pastDistance - changeInDistance - .02) || (supposedDistance >= pastDistance - changeInDistance + .02)){
            realDistance = supposedDistance;
            pastDistance = realDistance;
            changeInDistance = pastDistance - realDistance;
        }
        else {realDistance = pastDistance - changeInDistance;};
        return realDistance;
    }
}
