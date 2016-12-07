package org.firstinspires.ftc.teamcode.controllers.teleop;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.autonomous.TurnX;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.drivetrains.DriveTrain;

/**
 * Created by max on 12/7/16.
 * Aligns to the nearest interval of 90º.
 */
public class AlignToNearest implements Controller {
    private Instruments instruments;
    private DriveTrain driveTrain;
    private TurnX turnX;
    final double[] angles = {-180, -90, 0, 90, 180};
    public AlignToNearest(DriveTrain d, Instruments i) {
        driveTrain = d;
        instruments = i;
    }
    public boolean tick() {
        if (turnX != null) {
            boolean turned = turnX.tick();
            if (turned) {
                turnX = null;
            }
            return turned;
        }
        turnX = new TurnX(instruments, driveTrain, findClosest(instruments.yaw));
        return false;
    }
    private double findClosest(double yaw) {
        double distance = Math.abs(angles[0] - yaw);
        int idx = 0;
        for(int c = 1; c < angles.length; c++){
            double cdistance = Math.abs(angles[c] - yaw);
            if(cdistance < distance){
                idx = c;
                distance = cdistance;
            }
        }
        return angles[idx];
    }
}
