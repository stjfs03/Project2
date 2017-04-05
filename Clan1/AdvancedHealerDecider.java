package clanmelee.Clan1;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

/**
 * Purpose:Implements ActionPointDecider interface and provides a strategy for
 * an AdvancedHealerMember.
*
*/

public class AdvancedHealerDecider implements ActionPointDecider {
    private int actionPoints;

    /**
     * @Purpose: Instantiates an AdvancedHealerDecider
     * @param: actionPoints - how much healing it can do
     * @return: None (constructor)
     */
    public AdvancedHealerDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    /**
     * @purpose: Defines AdvancedHealerDecider's strategy.
     * @param: me - This healer
     * @param: other - The clan member that could be healed.
     * @return:
     */
    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        //Note: this will also return 0 if clanID's match to prevent combat among
        //members from the same clan.
        if (clanIDsMatch && other.getHitPoints() < (other.getMaxHitPoints() / 2))
            return actionPoints;
        else
            return 0;
    }
}
