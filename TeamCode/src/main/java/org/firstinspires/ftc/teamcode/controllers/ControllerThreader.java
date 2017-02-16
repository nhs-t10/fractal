package org.firstinspires.ftc.teamcode.controllers;

/**
 * Created by robotics on 2/16/17.
 */
public class ControllerThreader implements Controller, Runnable {
    private Controller c;

    public ControllerThreader(Controller c) {
        this.c = c;
    }

    @Override
    public boolean tick() {
        new Thread(new ControllerThreader(c)).start();
        return true;
    }

    @Override
    public void run() {
        while(!c.tick());
    }
}
