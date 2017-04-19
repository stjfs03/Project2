package clanmelee.ClanHaug;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class DodgeTankMemberDecider implements ActionPointDecider {

    public DodgeTankMemberDecider() {

    }
    /**
     *
     * @param self the player
     * @param target the character the player is interacting with.
     *               the tank will always run away.
     * @return the amount of actionPoints used
     */
    @Override
    public int decideActionPoints(ClanMember self, ClanMember target) {
        return 0;
    }
}
