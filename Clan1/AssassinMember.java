package clanmelee.Clan1;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

/**
 * @Purpose - Defines the instantiation of the AssassinMember clan member
 */
public class AssassinMember extends Clan {

    // Creates a Clan with the name "Assassin" and id of clanID
    public AssassinMember(int clanID) {
        super("Clan1", clanID);
    }

    /**
     *
     * @param hitPoints - The number of hit points to be distributed amongst all the clan members
     * @return - a clan (an ArrayList) of Assassins
     */
    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new AssassinDecider(16);

        int adjHitPoints = (int)(hitPoints * .40);
        while (adjHitPoints > 0) {
            int nextHP = 900;
            if (adjHitPoints < 900)
                nextHP = adjHitPoints;

            clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}
