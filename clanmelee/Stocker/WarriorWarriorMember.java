package clanmelee.Stocker;



import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;
import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.WARRIOR;
public class WarriorWarriorMember extends Clan{

    public WarriorWarriorMember(int clanID) {
        super("Warrior Warrior", clanID);
    }

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new WarriorWarriorDecider(20);

        int adjHitPoints = (int)(hitPoints * .40);
        while (adjHitPoints > 0) {
            int nextHP = 400;
            if (adjHitPoints < 400)
                nextHP = adjHitPoints;

            clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}
