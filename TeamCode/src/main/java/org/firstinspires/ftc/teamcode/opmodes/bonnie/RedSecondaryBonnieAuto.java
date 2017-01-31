package org.firstinspires.ftc.teamcode.opmodes.bonnie;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.controllers.Team;

/**
 * Created by Jacob on 1/31/2017.
 */
@Autonomous(name = "2nd RED bonnie *NOT BLUE*", group = "Autonomous")
public class RedSecondaryBonnieAuto extends SecondaryBonnieAuto{
    @Override
    public void setTeam() {
        team = Team.RED;
    }
}
