package org.firstinspires.ftc.teamcode.organs;

import org.firstinspires.ftc.teamcode.statics.Hardware;
import org.firstinspires.ftc.teamcode.tissues.TColor;
import org.firstinspires.ftc.teamcode.tissues.TIMU;
import org.firstinspires.ftc.teamcode.tissues.TLight;
import org.firstinspires.ftc.teamcode.tissues.TUltra;

/**
 * Created by max on 4/18/16.
 *
 * Represents the sensor array on the robot. Acts as an asynchronous state container for sensor values to prevent over-polling.
 * Could also manipulate motor mounted sensors.
 */
public class Instruments extends Thread {
    private static final long NANOS_PER_MILLI = 1000000L;

    //Sensors
    private TColor colorsensor;
    private TUltra ultrasensor;
    private TIMU imusensor;
    private TLight lightsensor1;
    private TLight lightsensor2;
    private TUltra irdistance;
    //data
    //please note that all data has an initial value of -1 to prevent the possibility of a client
    //getting sensor values before the thread has read any.
    private class Color {
        public double RED = -1;
        public double GREEN = -1;
        public double BLUE = -1;
        public double ALPHA = -1;
    }

    public final Color color = new Color();

    public double distance = -1;
    public double IRdistance = -1;
    public double yaw = -1;
    public double light1 = -1;
    public double light2 = -1;
    //thread variables
    private boolean gatherData;
    private long tickInterval;


    public Instruments() {
        //colorsensor = new TColor(Hardware.Color);
        ultrasensor = new TUltra(Hardware.Ultra);
        irdistance = new TUltra(Hardware.IRDistance);

        lightsensor1 = new TLight(Hardware.Lightone);
        lightsensor2 = new TLight(Hardware.Lighttwo);
        imusensor = new TIMU(Hardware.IMU);
        gatherData = false;
        tickInterval = 30 * NANOS_PER_MILLI;
    }

    /**
     * Set the interval at which the thread reads sensor values.
     * @param millis
     */
    public void setTickInterval(int millis) {
        tickInterval = millis* NANOS_PER_MILLI;
    }

    @Override
    public void run() {
        gatherData = true;

        long initialTime = System.nanoTime();

        while(gatherData) {
            if(System.nanoTime() - initialTime > tickInterval) {
                tick();
                initialTime = System.nanoTime();
            }
        }
    }

    /**
     * Stops the thread after the next readout is complete.
     */
    public void kill() {
        gatherData = false;
    }

    private void tick() {
        /*color.RED = colorsensor.red();
        color.BLUE = colorsensor.red();
        color.GREEN = colorsensor.red();
        color.ALPHA = colorsensor.alpha();*/

        distance = ultrasensor.voltage();
        IRdistance = irdistance.voltage();
        light1 = lightsensor1.reflectedValue();
        light2 = lightsensor2.reflectedValue();
        yaw = imusensor.getYaw();
    }


}