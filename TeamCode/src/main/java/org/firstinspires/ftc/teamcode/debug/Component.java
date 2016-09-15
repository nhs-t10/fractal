package org.firstinspires.ftc.teamcode.debug;

/**
 * Created by Admin on 4/17/2016.
 */
public interface Component {

    public abstract String getName();

    /**
     * Provides a basic test for the component
     * @return false until the test is complete.
     */
    public abstract Boolean test();
}
