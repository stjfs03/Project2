package clanmelee.Clan2;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class SimpleHealerDecider implements ActionPointDecider {
    private int actionPoints;

    public SimpleHealerDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    /**
     *
     * @param self The Player
     * @param target The character which the player is interacting with.
     *
     *               If the target is friendly and damaged, the player heals them
     *               Otherwise the player runs away
     *
     * @return the number of action points used
     */

    @Override
    public int decideActionPoints(ClanMember self, ClanMember target) {

        //Check if clan IDs match. If clan ID's match, both belong in the same clan.
        boolean clanIDsMatch = self.getClanID() == target.getClanID();

        //If target is in same clan
        if (clanIDsMatch) {

            //If teammate is significantly damaged --> heal
            if (target.getHitPoints() <= (0.8 * target.getMaxHitPoints())) {
                return actionPoints;
            }

            //If teammate still has most of their health or all of their health  --> retreat
            else {
                return 0;
            }
        }

        //If target is in different clan --> retreat
        else {
            return 0;
        }
    }
}