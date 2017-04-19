package clanmelee.ClanHaug;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

public class DodgeTankMember extends Clan {

    // Creates a Clan with the name "Dodge Tank" and id of clanID
    public DodgeTankMember(int clanID) {
        super("Dodge Tank", clanID);
    }

    /**
     *
     * @param hitPoints - The number of hit points to be distributed amongst all the clan members
     * @return - a clan (an ArrayList) of DodgeTanks
     */
    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new DodgeTankMemberDecider();

        int adjHitPoints = hitPoints;

        while (adjHitPoints > 0) {
            int nextHP = 1000;
            if (adjHitPoints < 1000)
                nextHP = adjHitPoints;

            clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}
