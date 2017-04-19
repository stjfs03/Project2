package clanmelee.ClanHaug;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class MeatyHealerMemberDecider implements ActionPointDecider {

    public MeatyHealerMemberDecider() {}

    /**
     *
     * @param self the player
     * @param target the character the player is interacting with.
     *               If self and target are in the same clan, then the player will use all their
     *               actionPoint to heal the target if the healer's health is greater than the
     *               difference between the targets maxHealth and currentHealth.
     *               Else the player runs away.
     * @return the amount of actionPoints used
     */
    @Override
    public int decideActionPoints(ClanMember self, ClanMember target) {

        boolean clanIDsMatch = self.getClanID() == target.getClanID();

        int targetHealth = target.getHitPoints();
        int targetMaxHealth = target.getMaxHitPoints();
        int difference = targetMaxHealth - targetHealth;


        if (clanIDsMatch) {

            if (targetHealth < targetMaxHealth) {
                if (self.getHitPoints() > difference) {return difference;}
            }
            else {return 10;}
        }

        return 0;
    }
}
