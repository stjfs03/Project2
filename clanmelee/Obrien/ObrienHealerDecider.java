package clanmelee.Obrien;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

/**
 * Created by Nemo on 4/18/17.
 */
public class ObrienHealerDecider implements ActionPointDecider {
    private int actionPoints;

    public ObrienHealerDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }


    @Override
    public int decideActionPoints(ClanMember self, ClanMember target) {

        //Check if clan IDs match. If clan ID's match, both belong in the same clan.
        boolean clanIDsMatch = self.getClanID() == target.getClanID();

        //If warrior, heal as much as possible. Else just heal actionpoints or run.
        if (clanIDsMatch && target.getType() == ClanMember.ClanMemberType.WARRIOR) {
            return target.getMaxHitPoints() - target.getHitPoints() <= self.getHitPoints() * 2 + 10? target.getMaxHitPoints() - target.getHitPoints():
            self.getHitPoints() * 2 + 10;
        }
        else if(clanIDsMatch){
            return actionPoints;
        }

        //If the target is in a different clan --> retreat
        else {
            return 0;
        }
    }
}
