package org.firstinspires.ftc.teamcode.lib;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.lasarobotics.vision.android.Cameras;
import org.lasarobotics.vision.ftc.resq.Beacon;
import org.lasarobotics.vision.opmode.VisionOpMode;
import org.lasarobotics.vision.opmode.extensions.CameraControlExtension;
import org.lasarobotics.vision.util.ScreenOrientation;
import org.opencv.core.Point;
import org.opencv.core.Size;

/**
 * Created by max on 11/3/16.
 */
public class LASABridge extends VisionOpMode {
    HardwareMap hardwareMap;
    public LASABridge(HardwareMap h) {
        hardwareMap = h;
        init();
    }
    @Override
    public void init() {
        super.init();
        Logger.logLine("Initialized Vision Library");
        this.setCamera(Cameras.PRIMARY); // set front camera
        this.setFrameSize(new Size(900, 900)); //size of camera view

        enableExtension(Extensions.BEACON);         //Beacon detection
        enableExtension(Extensions.ROTATION);       //Automatic screen rotation correction (pretty necessary for beacon)
        enableExtension(Extensions.CAMERA_CONTROL); //Manual camera control
        Logger.logLine("Extensions enabled");
        beacon.setAnalysisMethod(Beacon.AnalysisMethod.FAST);
        beacon.setColorToleranceRed(0);
        beacon.setColorToleranceBlue(0);
        Logger.logLine("Set tolerances");

        /**
         * Set analysis boundary
         * You should comment this to use the entire screen and uncomment only if
         * you want faster analysis at the cost of not using the entire frame.
         * This is also particularly useful if you know approximately where the beacon is
         * as this will eliminate parts of the frame which may cause problems
         * This will not work on some methods, such as COMPLEX
         **/
        //beacon.setAnalysisBounds(new Rectangle(new Point(width / 2, height / 2), width - 200, 200));

        rotation.setIsUsingSecondaryCamera(false);
        rotation.disableAutoRotate();
        rotation.setActivityOrientationFixed(ScreenOrientation.PORTRAIT);

        cameraControl.setColorTemperature(CameraControlExtension.ColorTemperature.AUTO);
        cameraControl.setAutoExposureCompensation();
        Logger.logLine("Finished init");

    }
    public Beacon.BeaconAnalysis getAnalysis() {
        super.loop();
        return beacon.getAnalysis();
    }
    public void setTolerances(double red, double blue) {
        beacon.setColorToleranceRed(red);
        beacon.setColorToleranceBlue(blue);
    }
    public void setColorTemperature(CameraControlExtension.ColorTemperature c) {
        cameraControl.setColorTemperature(c);
    }

    @Override
    public void stop() {
        super.stop();
    }

}
