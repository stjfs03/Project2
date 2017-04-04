package clanmelee.Clan1;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class BarbarianDecider implements ActionPointDecider {

    // the amount of actionPoints the BarbarianDecider has
    private int actionPoints;

    /**
     *
     * @param actionPoints the amount of actionPoints to set the Decider to
     */
    public BarbarianDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    /**
     *
     * @param self the player
     * @param target the character the player is interacting with.
     *               If self and target are in different clans then self will attack with all their actionPoints.
     *               Else self runs away.
     * @return the amount of actionPoints used
     */
    @Override
    public int decideActionPoints(ClanMember self, ClanMember target) {
        boolean clanIDsMatch = self.getClanID() == target.getClanID();

        if (!clanIDsMatch)
            return actionPoints;
        else
            return 0;
    }
}
