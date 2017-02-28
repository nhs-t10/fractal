package org.firstinspires.ftc.teamcode.opmodes.bonnie;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.teleop.ButtonPusher;
import org.firstinspires.ftc.teamcode.controllers.tests.TouchRetracter;
import org.firstinspires.ftc.teamcode.opmodes.T10Opmode;
import org.firstinspires.ftc.teamcode.organs.ButtonRoller;
import org.firstinspires.ftc.teamcode.organs.Pusher;
import org.firstinspires.ftc.teamcode.organs.RollerStopper;
import org.firstinspires.ftc.teamcode.organs.Spacers;

import java.util.ArrayList;

/**
 * Created by max on 2/18/17.
 */
@TeleOp(name="Maintenance", group="Bonnie")
public class Maintenance extends T10Opmode {
    private ArrayList<Controller> controllers = new ArrayList<Controller>();
    @Override
    public void run() {
        controllers.add(new TouchRetracter(new RollerStopper(), new ButtonRoller(), new Spacers()));
        controllers.add(new ButtonPusher(new Pusher()));
    }
    public void tick() {
        for(int i=0; i<controllers.size(); i++) {
            controllers.get(i).tick();
        }
    }
}
