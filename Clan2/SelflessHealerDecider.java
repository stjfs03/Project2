package clanmelee.Clan2;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class SelflessHealerDecider implements ActionPointDecider {

    private int actionPoints;

    public SelflessHealerDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    /**
     *
     * @param self The player
     * @param target The character the player is interacting with
     *               If target are in the same clan as the player, the player heals the target.
     *               Otherwise the player runs away.
     * @return  The amount of action points used
     */
    @Override
    public int decideActionPoints(ClanMember self, ClanMember target) {

        //Check if clan IDs match. If clan ID's match, both belong in the same clan.
        boolean clanIDsMatch = self.getClanID() == target.getClanID();

        //If the target is in the same clan --> heal
        if (clanIDsMatch) {
            return actionPoints;
        }

        //If the target is in a different clan --> retreat
        else {
            return 0;
        }
    }
}
