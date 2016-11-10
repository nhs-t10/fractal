package org.firstinspires.ftc.teamcode.tissues;

import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.lib.LASABridge;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.lasarobotics.vision.ftc.resq.Beacon;
import org.opencv.core.Point;

/**
 * Created by max on 11/3/16.
 */
public class TCamera implements Component {
    private LASABridge bridge;
    public TCamera() {
        bridge = new LASABridge(Hardware.getHardwareMap());
        bridge.setTolerances(0, 0);
    }
    public String getString() {
        return bridge.getAnalysis().toString();
    }
    public Beacon.BeaconAnalysis getAnalysis() {
        return bridge.getAnalysis();
    }
    /**
     * Find beacon state colors
     * @return {Left Color, Right Color}
     */
    public Beacon.BeaconColor[] getBeaconState() {
        Beacon.BeaconAnalysis analysis = bridge.getAnalysis();
        return new Beacon.BeaconColor[] {analysis.getStateLeft(), analysis.getStateRight()};
    }
    public String getName() {
        return "LASA Camera";
    }
    public boolean test() {
        return true;
    }
}
