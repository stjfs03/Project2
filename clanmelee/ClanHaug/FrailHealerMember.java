package clanmelee.ClanHaug;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.HEALER;

public class FrailHealerMember extends Clan {

    // Creates a Clan with the name "Frail Healer" and id of clanID
    public FrailHealerMember(int clanID) {
        super("Frail Healer", clanID);
    }

    /**
     *
     * @param hitPoints - The number of hit points to be distributed amongst all the clan members
     * @return - a clan (an ArrayList) of Frail Healers
     */
    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new FrailHealerMemberDecider();

        int adjHitPoints = hitPoints;

        while (adjHitPoints > 0) {
            int nextHP = 250;
            if (adjHitPoints < 250)
                nextHP = adjHitPoints;

            clanMembers.add(new ClanMember(getClanID(), HEALER, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}
