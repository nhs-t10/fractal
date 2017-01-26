package org.firstinspires.ftc.teamcode.tissues;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.lib.LASABridge;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.lasarobotics.vision.ftc.resq.Beacon;

/**
 * Created by max on 11/3/16.
 */
/*
CRITICAL:
You MUST call .stop() at the end of an opmode. Otherwise, the app WILL CRASH.
* */
public class TCamera implements Component {
    public LASABridge bridge;
    public float redTolerance = -0.1f;
    public float blueTolerance = 0f;
    public TCamera() {
        Logger.logLine("Camera is initializing...");
        bridge = new LASABridge(Hardware.getHardwareMap());
        bridge.setTolerances(redTolerance, blueTolerance);
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
