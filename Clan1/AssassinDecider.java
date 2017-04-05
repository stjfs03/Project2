package clanmelee.Clan1;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

import static clanmelee.ClanMember.ClanMemberType.HEALER;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

/**
 * Implements ActionPointDecider interface and provides a strategy for
 * an AssassinMember.
 */
public class AssassinDecider implements ActionPointDecider {
    private int actionPoints;

    /**
     * @param actionPoints - how much damage the assassin can do
     */
    public AssassinDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    /**
     * This method checks to see if the confronting clan members are of the same clan before making a move.
     * If the IDs match: return 0. If the IDs are different: the assassin will attack.
     *
     * @param me - Our Assassin clan member
     * @param other - Our opponent
     * @return - Amount of damage to be dealt to 'other'
     */
    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        if (!clanIDsMatch && other.getType() == WARRIOR) {

            //if opponent's current health is less then or equal to opponet's MaxHealth / 3
            if (other.getHitPoints() <= (other.getMaxHitPoints() / 3)) {
                // deal 3x damage
                return actionPoints * 3;
            }
            else { //else deal normal damage
                return actionPoints;
            }
        }
        //if the opponent is a healer deal 2x damage
        if (!clanIDsMatch && other.getType() == HEALER) {
            return actionPoints * 2;
        }
        //return 0 if the clan IDs match
        return  0;
    }
}
