package clanmelee.Stocker;
import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class WarriorWarriorDecider implements ActionPointDecider {
    private int actionPoints;

    public WarriorWarriorDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember self, ClanMember target) {

        boolean clanIDsMatch = self.getClanID() == target.getClanID();

        if (clanIDsMatch) {
            return 0;
        }
        else {
            if(target.getHitPoints() > 10)
                return actionPoints;
            else{
                return 10;
            }
        }
    }
}
