package clanmelee.Obrien;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

/**
 * Created by Nemo on 4/18/17.
 */
public class ObrienWarriorDecider implements ActionPointDecider {
    private int actionPoints;

    public ObrienWarriorDecider(int actionPoints){
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember self, ClanMember target) {

        //Check if clan IDs match. If clan ID's match, both are in the same clan.
        boolean clanIDsMatch = self.getClanID() == target.getClanID();


        if (!clanIDsMatch && target.getType() == ClanMember.ClanMemberType.HEALER) {
            return actionPoints;
        }

        else {
            return 0;
        }
    }

}
