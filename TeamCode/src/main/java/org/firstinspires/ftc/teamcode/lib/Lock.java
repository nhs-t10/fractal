package org.firstinspires.ftc.teamcode.lib;

/**
 * Created by robotics on 1/24/17.
 */
public class Lock {
    public static final String DEFAULT_PASS = "pass";

    private boolean lockedstate = false;
    private String pass = DEFAULT_PASS;

    public void lock() {
        lock(DEFAULT_PASS);
    }

    public void lock(String key) {
        if(!isLocked()) {
            lockedstate = true;
            pass = key;
        }
    }

    public void ulock() {
        ulock(DEFAULT_PASS);
    }

    public void ulock(String key) {
        if(pass.equals(key)) {
            lockedstate = false;
        }
    }

    public boolean isLocked() {
        return lockedstate;
    }

    public boolean usesKey(String key) {
        return pass.equals(key);
    }
}
