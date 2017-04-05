package clanmelee.Clan1;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.HEALER;

public class StandardHealerMember extends Clan {

    // Creates a Clan with the name "Standard Healer" and id of clanID
    public StandardHealerMember(int clanID) {
        super("Standard Healer", clanID);
    }

    /**
     *
     * @param - hitPoints the number of hit points to be distributed amongst all the clan members
     * @return - a clan (an ArrayList) of StandardHealers
     */
    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new StandardHealerDecider(10);

        int adjHitPoints = (int)(hitPoints * .15);
        while (adjHitPoints > 0) {
            int nextHP = 200;
            if (adjHitPoints < 200)
                nextHP = adjHitPoints;

            clanMembers.add(new ClanMember(getClanID(), HEALER, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}
