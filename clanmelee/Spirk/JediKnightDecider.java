package clanmelee.Spirk;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class JediKnightDecider implements ActionPointDecider {
    private int actionPoints;

    public JediKnightDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        //if other is enemy warrior, deal damage
        if (!clanIDsMatch && other.getType() == ClanMember.ClanMemberType.WARRIOR) {
            return (me.getMaxHitPoints() * 2) + (actionPoints - 2);
        }
        //if other is enemy healer, leave him be, for he cannot defend himself (also leave friendlies alone)
        return 0;
    }
}
