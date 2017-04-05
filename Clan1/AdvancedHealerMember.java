package clanmelee.Clan1;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.HEALER;

/**
 * @Purpose: Defines the AdvancedHealerMember clan member
 *
 */
public class AdvancedHealerMember extends Clan{

    /**
     * @purpose: Instantiates an AdvancedHealerMember
     * @param: clanID - Unique number identifying the clan.
     * @return: None (constructor)
     */
    public AdvancedHealerMember(int clanID) {
        super("Advanced Healer", clanID);
    }

    /**
     * @Purpose: Creates an ArrayList and fills with with the desired number of Healers.
     * @param hitPoints-the number of hit points used to create the desired healers
     * @return: The list of created healers. 
     */
    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new AdvancedHealerDecider(20);

        int adjHitPoints = (int)(hitPoints * .15);
        while (adjHitPoints > 0) {
            int nextHP = 600;
            if (adjHitPoints < 600)
                nextHP = adjHitPoints;

            clanMembers.add(new ClanMember(getClanID(), HEALER, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}
