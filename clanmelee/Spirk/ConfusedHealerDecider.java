package clanmelee.Spirk;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class ConfusedHealerDecider implements ActionPointDecider {
    private int actionPoints;

    public ConfusedHealerDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {

        //heals whoever he happens upon
        return actionPoints;
    }
}
