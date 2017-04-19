package clanmelee.Stocker;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;
import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.HEALER;
public class DrLuigiHealerMember extends Clan{
    public DrLuigiHealerMember(int clanID) {
        super("Dr Luigi Healer", clanID);
    }

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new DrLuigiHealerDecider(10);

        int adjHitPoints = (int)(hitPoints * .10);
        while (adjHitPoints > 0) {
            int nextHP = 30;
            if (adjHitPoints < 30)
                nextHP = adjHitPoints;

            clanMembers.add(new ClanMember(getClanID(), HEALER, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}
