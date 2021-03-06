package clanmelee.Madilia;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class HealerHealerDecider implements ActionPointDecider {
    private int actionPoints;

    /**
     *
     * @param actionPoints the amount of actionPoints to set the Decider to
     */
    public HealerHealerDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    /**
     *
     * @param player the player who's turn it is
     * @param target the character that the player wants to interact with
     * @return the magnitude of an action (attacking or healing) . A player runs away if Action points are 0 or
     * less.
     */
    @Override
    public int decideActionPoints(ClanMember player, ClanMember target) {
        boolean clanIDsMatch = player.getClanID() == target.getClanID();

        // If the opponent is in the same clan and is also a healer, that healer will be healed.
        if (clanIDsMatch) {
            if (target.getType().equals(ClanMember.ClanMemberType.HEALER)) {
                return actionPoints;
            }
        }

        // The healer will run if the opponent is not in the same clan.
        return 0;
    }
}
