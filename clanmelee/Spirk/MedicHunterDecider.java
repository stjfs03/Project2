package clanmelee.Spirk;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class MedicHunterDecider implements ActionPointDecider {
    private int actionPoints;

    public MedicHunterDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        //if other is an enemy medic, deal as much damage as you can
        if (!clanIDsMatch && other.getType() == ClanMember.ClanMemberType.HEALER) {
            return ((me.getMaxHitPoints() * 2) + actionPoints);
        }
        //if other is one of our own, just take a quick jab at him
        if (clanIDsMatch && other.getType() == ClanMember.ClanMemberType.HEALER) {
            return 1;
        }
        //else run away
        return 0;
    }
}
