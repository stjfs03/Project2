package clanmelee.Balga;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class ZacWarriorDecider implements ActionPointDecider {

    private int actionPoints;

    public ZacWarriorDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember self, ClanMember target) {

        //Check if clan IDs match. If ID's match both are in the same clan
        boolean clanIDsMatch = self.getClanID() == target.getClanID();

        //If target is in a different clan
        if (!clanIDsMatch) {

            // If the warrior's hitPoints are above half its maxHitPoints then deal double damage
            if (self.getHitPoints() > self.getMaxHitPoints() / 2) {
                return actionPoints*2;
            }

            // If target's hitPoints are double the warrior's hitpoints, then try to run
            else if (target.getHitPoints() > self.getHitPoints() * 2) {
                return 0;
            }

            //Any other situation just return normal damage
            else {
                return actionPoints;
            }
        }

        // If same clan then retreat
        else {
            return 0;
        }


    }
}