package clanmelee.Clan2;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

public class AngryWarriorDecider  implements ActionPointDecider {

    private int actionPoints;

    public AngryWarriorDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }


    /**
     *
     * @param self The player
     * @param target The character the player is interacting with.
     *               If target is friendly, the player runs away.
     *               If the target is an enemy, the player attacks.
     * @return the amount of actionPoints used
     */
    @Override
    public int decideActionPoints(ClanMember self, ClanMember target) {

        //Check if clan IDs match. If clan ID's match, both are in the same clan.
        boolean clanIDsMatch = self.getClanID() == target.getClanID();

        //If the target is in a different clan --> fight
        if (!clanIDsMatch) {
            return actionPoints;
        }

        //If the target is in the same clan --> retreat
        else {
            return 0;
        }
    }
}
