package org.firstinspires.ftc.teamcode.opmodes.bonnie;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.controllers.Team;

/**
 * Created by Jacob on 1/31/2017.
 */
@Autonomous(name = "2nd blue bonnie", group ="Autonomous")
public class BlueSecondaryBonnieAuto extends SecondaryBonnieAuto {
    @Override
    public void setTeam() {
        team = Team.BLUE;
    }
}
