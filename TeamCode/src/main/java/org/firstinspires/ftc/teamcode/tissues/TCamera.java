package org.firstinspires.ftc.teamcode.tissues;

import android.provider.OpenableColumns;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.teamcode.debug.Component;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by robotics on 9/29/16.
 */
public class TCamera implements Component {
    //licence key for Vuforia. Do not modify.
    public static final String VUFORIA_LICENSE = "AWGA/3L/////AAAAGeahoC4tN0IJgF53akSKrxkR3Ls0B7LP83nYeNJ+jfDrbgtKIhUa8j3IUmwJC+9EmmZ0E3hjW+SlI5FvbMes4w+rVMN3x6mI2YiWxiOBdv0fSuNcXeDlyxydFl3cAeU5PRJhxZTtbYr09a0D9Jcr37kBipd0u/IZglhh2hjGzhKdhX0Z/TOHWUdiHOBNA5+IgMlR44goMoT1c6LQULe/IvmZgKHR0XL7nDLKtkiPyvevobBe34HLPlpY0bjDrbBI6zMliL3Ce+AWnsTMxT9HWmoSxC0Q6r/DVfrGlmphLY1AKKHbswwuBOgKb3zGE43xonFJhaSiQtVWc7Imi0KNucI6eCBafLfcu364iOzeBP1u";

    //The following values are in mm
    public static final float mmPerInch = 25.4f;
    public static final float robotWidth = 18 * mmPerInch;
    public static final float fieldWidth = (12*12 - 2) * mmPerInch;

    private List<VuforiaTrackable> trackableList = new ArrayList<VuforiaTrackable>();
    private VuforiaLocalizer vuforia;

    public TCamera() {
        if(VUFORIA_LICENSE.length() != 380) {
            throw new SecurityException("Invalid Vuforia key! Camera likely will NOT work");
        }

        VuforiaLocalizer.Parameters params = new VuforiaLocalizer.Parameters();
        params.vuforiaLicenseKey = VUFORIA_LICENSE;
        params.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        this.vuforia = ClassFactory.createVuforiaLocalizer(params);
    }

    public void setCameraLocation(float x, float y, float z) {
        //OpenGLMatrix phoneLoc = OpenGLMatrix.translation(x,y,z).multiplied(AxesReference.EXTRINSIC, AxesOrder.YZY, AngleUnit.DEGREES, 0, 0, 0);
    }

    public void addTrackable(String name, String vuforiaAsset, int index) {
        VuforiaTrackable vt = this.vuforia.loadTrackablesFromAsset(vuforiaAsset).get(index);
        vt.setName(name);
        trackableList.add(vt);
    }

    public void addTrackable(String name, String vuforiaAsset) {
        addTrackable(name, vuforiaAsset, 0);
    }

    public VuforiaTrackable getTrackable(int index) {
        return trackableList.get(index);
    }

    @Override
    public String getName() {
        return "Phone Camera";
    }

    @Override
    public boolean test() {
        return null;
    }
}
