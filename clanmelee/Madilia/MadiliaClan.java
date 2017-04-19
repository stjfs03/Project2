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

        if ( totalHP < 5000 ){
            while ( unassignedHP > 0){
                int nextWarriorHP = 25;
                if (unassignedHP < 25){
                    nextWarriorHP = unassignedHP;
                }
                clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextWarriorHP, badWarriorDecider));
//                clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextWarriorHP, regularDecider));
            }

            while (unassignedHP > 0) {
                int nextHealerHPAssignment = 25;
                if (unassignedHP < 25) {
                    nextHealerHPAssignment = unassignedHP;
                }
                clanMembers.add(new ClanMember(getClanID(), HEALER, nextHealerHPAssignment, healerHealerDecider));
//                clanMembers.add(new ClanMember(getClanID(), HEALER, nextHealerHPAssignment, assistantDecider));

                unassignedHP -= nextHealerHPAssignment;
            }
        }
        else {
            while (unassignedHP > 0) {
                int nextWarriorHPAssignment = 5000;
                if (unassignedHP < 5000) {
                    nextWarriorHPAssignment = unassignedHP;
                }
//                clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextWarriorHPAssignment, braveDecider));
//                clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextWarriorHPAssignment, regularDecider));

                unassignedHP -= nextWarriorHPAssignment;
            }

            while (unassignedHP > 0) {
                int nextHealerHPAssignment = 5000;
                if (unassignedHP < 5000) {
                    nextHealerHPAssignment = unassignedHP;
                }
//                clanMembers.add(new ClanMember(getClanID(), HEALER, nextHealerHPAssignment, doctorDecider));
//                clanMembers.add(new ClanMember(getClanID(), HEALER, nextHealerHPAssignment, assistantDecider));

                unassignedHP -= nextHealerHPAssignment;
            }
        }

        return clanMembers;
    }
}
