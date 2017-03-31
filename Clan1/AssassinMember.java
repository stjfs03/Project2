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

    /**
     * @param - clanID - number designated as clan ID
     */
    public AssassinMember(int clanID) {
        super("Clan1", clanID);
    }

    /**
     * This method creates an ArrayList and fills it with the desired number of Assassins
     * (later to be added to the full clan members array? - According to Dr Schaper)
     *
     * @param hitPoints - The number of hit points to be distributed amongst all the clan members
     * @return - an ArrayList of Assassins
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
