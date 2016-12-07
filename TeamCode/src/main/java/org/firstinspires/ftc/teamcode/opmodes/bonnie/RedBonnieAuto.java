package org.firstinspires.ftc.teamcode.opmodes.bonnie;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.controllers.Team;

/**
 * Created by max on 11/15/16.
 */
@Autonomous(name="Red Bonnie", group="Autonomous")
public class RedBonnieAuto extends BonnieAuto {
    @Override
    public void setTeam() {
        team = Team.RED;
    }
}
