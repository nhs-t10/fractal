package org.firstinspires.ftc.teamcode.opmodes.bonnie;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.controllers.Team;

/**
 * Created by max on 11/15/16.
 */
@Autonomous(name="Blue Bonnie", group="Autonomous")
public class BlueBonnieAuto extends BonnieAuto {
    public BlueBonnieAuto() {
        DRIVE_FROM_WALL_LIM = 0.24;
        TURNX_TO_VORTEX = 90.0;
        TURNX_TO_LINE = -55.0;
        TURNX_TO_WALL = -90.0;
        SIDEWAYS_POWER = 0.3f;
        DRIFT_TO_LINE_SPD = -0.15f;
        DRIFT_TO_LINE_SPD_2 = 0.15f;
    }
    @Override
    public void setTeam() {
        team = Team.BLUE;
    }
}
