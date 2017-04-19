package clanmelee.Sobrino;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

/**
 * Created by mariosobrino on 4/18/17.
 */
public class BraveWarriorDecider implements ActionPointDecider {

    private int actionPoints;

    public BraveWarriorDecider(int actionPoints){ this.actionPoints = actionPoints; }

    @Override
    public int decideActionPoints(ClanMember self, ClanMember target){

        boolean clanIDsMatch = self.getClanID() == target.getClanID();

        //If target is in different clan --> attack using maximum actionPoints
        if (!clanIDsMatch) {
           return actionPoints + 5;
        }

        //If target is in same clan --> retreat
        else {
            return 0;
        }
    }

}
