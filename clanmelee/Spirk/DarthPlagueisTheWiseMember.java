package clanmelee.Spirk;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;
import java.util.ArrayList;
import static clanmelee.ClanMember.ClanMemberType.HEALER;

public class DarthPlagueisTheWiseMember extends Clan {

    public DarthPlagueisTheWiseMember(int clanID) {
        super("Darth Plagueis the Wise", clanID);
    }

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new DarthPlagueisTheWiseDecider(15);

        int adjHitPoints = (int) (hitPoints * .25);
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

