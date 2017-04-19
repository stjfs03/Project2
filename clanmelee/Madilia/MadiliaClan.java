package clanmelee.Madilia;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.Clan;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.WARRIOR;
import static clanmelee.ClanMember.ClanMemberType.HEALER;

public class MadiliaClan extends Clan {

    private ActionPointDecider badWarriorDecider;
    private ActionPointDecider healerHealerDecider;

    public MadiliaClan(int clanID) {
        super("MadiliaClan", clanID);

        badWarriorDecider = new BadWarriorDecider(10);
        healerHealerDecider = new HealerHealerDecider(10);
    }

    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        int totalHP = hitPoints;
        int unassignedHP = hitPoints;
        int nextHpAssignment;

        while (unassignedHP > 0) {
            nextHpAssignment = totalHP/10;
            if (unassignedHP < totalHP/10) {
                nextHpAssignment = unassignedHP;
            }

            if (Math.random() > 0.5) {
                if (Math.random() > 0.5) {
                    clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextHpAssignment, badWarriorDecider));
                }

                else {
                    clanMembers.add(new ClanMember(getClanID(), HEALER, nextHpAssignment, healerHealerDecider));
                }
            }
            unassignedHP -= nextHpAssignment;
        }

        return clanMembers;
    }
}
