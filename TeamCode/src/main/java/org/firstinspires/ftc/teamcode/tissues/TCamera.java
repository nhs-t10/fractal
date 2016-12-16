package org.firstinspires.ftc.teamcode.tissues;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.lib.LASABridge;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.lasarobotics.vision.ftc.resq.Beacon;
import org.opencv.core.Point;

/**
 * Created by max on 11/3/16.
 */
/*
CRITICAL:
You MUST call .stop() at the end of an opmode. Otherwise, the app WILL CRASH.
* */
public class TCamera implements Component {
    private LASABridge bridge;
    public TCamera() {
        Logger.logLine("Camera is initializing...");
        bridge = new LASABridge(Hardware.getHardwareMap());
        bridge.setTolerances(-0.8f, 0.5f);
    }
    public String getString() {
        return bridge.getAnalysis().toString();
    }
    public Beacon.BeaconAnalysis getAnalysis() {
        return bridge.getAnalysis();
    }
    public String getName() {
        return "LASA Camera";
    }
    public boolean test() {
        Logger.logLine(getString());
        return true;
    }
    public void stop() {
        bridge.stop();
    }
}
