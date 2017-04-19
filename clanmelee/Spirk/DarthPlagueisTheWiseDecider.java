package clanmelee.Spirk;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class DarthPlagueisTheWiseDecider implements ActionPointDecider {
    private int actionPoints;

    public DarthPlagueisTheWiseDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        //ironically, he could save others from death...
        if (clanIDsMatch && other.getHitPoints() <= (.25 * other.getMaxHitPoints())) {
            return (me.getMaxHitPoints() * 2) + actionPoints;
        }
        //...but not himself
        return 1;
    }
}
