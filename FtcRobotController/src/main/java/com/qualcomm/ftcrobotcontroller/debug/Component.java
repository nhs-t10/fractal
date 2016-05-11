package com.qualcomm.ftcrobotcontroller.debug;

/**
 * Created by Admin on 4/17/2016.
 */
public interface Component {
    //temporary var to fix syntax errors
    public String name = "";

    /**
     * Provides a basic test for the component
     * @return false until the test is complete.
     */
    public abstract Boolean test();
}
