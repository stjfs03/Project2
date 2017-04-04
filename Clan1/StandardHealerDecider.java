package clanmelee.Clan1;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class StandardHealerDecider implements ActionPointDecider {

    // the amount of actionPoints the StandardHealerDecider has
    private int actionPoints;

    /**
     *
      * @param actionPoints the amount of actionPoints to set the Decider to
     */
    public StandardHealerDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    /**
     *
     * @param self the player
     * @param target the character the player is interacting with.
     *               If self and target are in the same clan, then the player will use all their actionPoints
     *               to heal the target. Else the player runs away.
     * @return the amount of actionPoints used
     */
    @Override
    public int decideActionPoints(ClanMember self, ClanMember target) {

        boolean clanIDsMatch = self.getClanID() == target.getClanID();

        if (clanIDsMatch) {
            return actionPoints;
        }
        else {
            return 0;
        }
    }
}
