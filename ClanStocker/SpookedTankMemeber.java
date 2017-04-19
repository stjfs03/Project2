package clanmelee.ClanStocker;



import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;
import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

public class SpookedTankMemeber extends Clan{
    public SpookedTankMemeber(int clanID) {
        super("Spooked Tank", clanID);
    }

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new SpookedTankDecider(10);

        int adjHitPoints = (int)(hitPoints * .50);
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
