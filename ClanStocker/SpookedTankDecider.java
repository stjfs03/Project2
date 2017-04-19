package clanmelee.ClanStocker;
import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class SpookedTankDecider implements ActionPointDecider {

    private int actionPoints;

    public SpookedTankDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember self, ClanMember target) {
        return 0;
    }
}
