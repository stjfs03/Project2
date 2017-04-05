package clanmelee.Clan2;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class SimpleWarriorDecider implements ActionPointDecider {

    private int actionPoints;

    public SimpleWarriorDecider(int actionPoints) {
            this.actionPoints = actionPoints;
        }

    /**
     *
     * @param self The player
     * @param target The character which the player is interacting with
     *
     *               If the target is an enemy:
     *                  - If the player is not close to death and the enemy does not have a substantial amount of
     *                    health which gives them an advantage, then the player attacks.
     *                  - Else the player runs away
     *
     * @return The number of action points used
     */
    @Override
    public int decideActionPoints(ClanMember self, ClanMember target) {

        //Check if clan IDs match. If ID's match both are in the same clan
        boolean clanIDsMatch = self.getClanID() == target.getClanID();

        //If target is in a different clan
        if (!clanIDsMatch) {

            //If self is not close to death and opponent has a similar amount of health as the player --> attack
            if ((self.getHitPoints() - actionPoints > 0 && self.getHitPoints() * 2 >= target.getHitPoints())) {
                return actionPoints;
            }

            //If opponent's health has a larger amount health or if self is close to death --> retreat
            else {
                return 0;
            }
        }

        //If target is in the same clan --> retreat
        else {
            return 0;
        }
    }

}
