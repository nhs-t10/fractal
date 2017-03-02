package org.firstinspires.ftc.teamcode.opmodes.bonnie;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.controllers.Team;

/**
 * Created by max on 11/15/16.
 */
@Autonomous(name="Red Bonnie", group="Autonomous")
public class RedBonnieAuto extends BonnieAuto {
    public RedBonnieAuto() {
        DRIVE_FROM_WALL_LIM = 0.24;
        TURNX_TO_VORTEX = 90.0;
        TURNX_TO_LINE = 47.0;
        TURNX_TO_WALL = 90.0;
        SIDEWAYS_POWER = -0.3f;
        DRIFT_TO_LINE_SPD = 0.13f;
        DRIFT_TO_LINE_SPD_2 = -0.13f;
    }

    @Override
    public void setTeam() {
        team = Team.RED;
    }
}
