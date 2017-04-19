package clanmelee.Sobrino;

/**
 * Created by mariosobrino on 4/18/17.
 */

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class DoctorDecider implements ActionPointDecider{

    private int actionPoints;

    public DoctorDecider(int actionPoints){ this.actionPoints = actionPoints;}

    @Override
    public int decideActionPoints(ClanMember self, ClanMember target){

        boolean clanIDsMatch = self.getClanID() == target.getClanID();

        if (clanIDsMatch){

            //If target is in same clan and had less than 3/4 max health --> heal
            if (target.getHitPoints() < (target.getMaxHitPoints() * 0.75)){
                return actionPoints;
            }
            //Else --> run away
            else{
                return 0;
            }

        }
        //If target not in same clan --> run away
        else{
            return 0;
        }


    }

}
