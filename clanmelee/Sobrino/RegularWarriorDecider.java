package clanmelee.Sobrino;

/**
 * Created by mariosobrino on 4/18/17.
 */

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class RegularWarriorDecider implements ActionPointDecider{

    private int actionPoints;

    public RegularWarriorDecider(int actionPoints){ this.actionPoints = actionPoints; }

    @Override
    public int decideActionPoints(ClanMember self, ClanMember target){

        boolean clanIDsMatch = self.getClanID() == target.getClanID();

        if (!clanIDsMatch){
            return actionPoints;
        }
        else{
            return 0;
        }

    }

}
