package clanmelee.Stocker;


import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class DrLuigiHealerDecider implements ActionPointDecider {
    private int actionPoints;
    public DrLuigiHealerDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

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
