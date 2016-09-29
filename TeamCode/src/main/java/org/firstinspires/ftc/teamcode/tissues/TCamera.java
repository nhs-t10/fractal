package org.firstinspires.ftc.teamcode.tissues;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.teamcode.debug.Component;

/**
 * Created by robotics on 9/29/16.
 */
public class TCamera implements Component {
    //licence key for Vuforia. Do not modify.
    public static final String VUFORIA_LICENSE = "AWGA/3L/////AAAAGeahoC4tN0IJgF53akSKrxkR3Ls0B7LP83nYeNJ+jfDrbgtKIhUa8j3IUmwJC+9EmmZ0E3hjW+SlI5FvbMes4w+rVMN3x6mI2YiWxiOBdv0fSuNcXeDlyxydFl3cAeU5PRJhxZTtbYr09a0D9Jcr37kBipd0u/IZglhh2hjGzhKdhX0Z/TOHWUdiHOBNA5+IgMlR44goMoT1c6LQULe/IvmZgKHR0XL7nDLKtkiPyvevobBe34HLPlpY0bjDrbBI6zMliL3Ce+AWnsTMxT9HWmoSxC0Q6r/DVfrGlmphLY1AKKHbswwuBOgKb3zGE43xonFJhaSiQtVWc7Imi0KNucI6eCBafLfcu364iOzeBP1u";

    VuforiaLocalizer vuforia;

    public TCamera() {
        if(VUFORIA_LICENSE.length() != 380) {
            throw new SecurityException("Invalid Vuforia key! Camera likely will NOT work");
        }

        VuforiaLocalizer.Parameters params = new VuforiaLocalizer.Parameters();
        params.vuforiaLicenseKey = VUFORIA_LICENSE;
        params.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        this.vuforia = ClassFactory.createVuforiaLocalizer(params);
    }

    @Override
    public String getName() {
        return "Phone Camera";
    }

    @Override
    public Boolean test() {
        return null;
    }
}
