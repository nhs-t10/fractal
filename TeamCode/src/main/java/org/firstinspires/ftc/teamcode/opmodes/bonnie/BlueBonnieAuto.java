package org.firstinspires.ftc.teamcode.opmodes.bonnie;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.controllers.Team;

/**
 * Created by max on 11/15/16.
 */
@Autonomous(name="Blue Bonnie", group="Autonomous")
public class BlueBonnieAuto extends BonnieAuto {
    @Override
    public void setTeam() {
        team = Team.BLUE;
    }
}
