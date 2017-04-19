package clanmelee.ClanHaug;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class FrailHealerMemberDecider implements ActionPointDecider {

    public FrailHealerMemberDecider() {}

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
            return 10;
        }
        else {
            return 0;
        }
    }
}
