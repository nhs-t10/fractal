package org.firstinspires.ftc.teamcode.controllers.tests;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.Team;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.BeaconCheck;
import org.firstinspires.ftc.teamcode.neurons.DebouncingButton;
import org.firstinspires.ftc.teamcode.tissues.TCamera;
import org.lasarobotics.vision.opmode.extensions.CameraControlExtension;

/**
 * Created by Jacob on 1/10/2017.
 */

public class CameraAdjuster implements Controller {
    private TCamera camera;
    private BeaconCheck bc;
    private boolean changingRed = false;
    private float red;
    private float blue;

    private DebouncingButton up = new DebouncingButton("DU1");
    private DebouncingButton down = new DebouncingButton("DD1");
    private DebouncingButton changeColor = new DebouncingButton("Y1");
    private DebouncingButton changeTemp = new DebouncingButton("X1") ;
    private boolean yummyTemp = false;

    public CameraAdjuster (TCamera c) {
        bc = new BeaconCheck(Team.RED);
        camera = c;
        red = camera.redTolerance;
        blue = camera.blueTolerance;
    }
    private void render() {
        Logger.addData("Changing: ", (changingRed ? "Red" : "Blue"));
        Logger.addData("Red cal: ", "" + red);
        Logger.addData("Blue cal: ", "" + blue);
        Logger.addData("Temp: ", (yummyTemp ? "Auto" : "5000 fluorescent"));
        Logger.addData("Cam: ", camera.getString());
    }
    private void set() {
        camera.bridge.setTolerances(red, blue);
        camera.bridge.setColorTemperature((yummyTemp ? CameraControlExtension.ColorTemperature.AUTO : CameraControlExtension.ColorTemperature.K5000_FLOURESCENT));
    }
    public boolean tick() {
        if (up.getToggle()) {
            if (changingRed) red+=-0.1;
            else blue+=0.1;
            set();
        }
        if (down.getToggle()) {
            if (changingRed) red-=0.1;
            else blue-=0.1;
            set();
        }
        if (changeColor.getToggle()) {
            changingRed = !changingRed;
            set();
        }
        if(changeTemp.getToggle()) {
            yummyTemp = !yummyTemp;
            set();
        }
        render();
        return false;
    }
}
