package org.firstinspires.ftc.teamcode.opmodes.clyde;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.controllers.Team;

/**
 * Created by max on 11/15/16.
 */
@Autonomous(name="Blue Beacon", group="Autoomous")
public class BlueBeaconAuto extends BeaconAuto {
    @Override
    public void setTeam() {
        team = Team.BLUE;
    }
}
