package clanmelee.Balga;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.Clan;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;
import static clanmelee.ClanMember.ClanMemberType.HEALER;

import java.util.ArrayList;

public class BalgaClan extends Clan {


    private ActionPointDecider zacWDecider;
    private ActionPointDecider zacHDecider;



    /**
     * @param clanID The identity of a clan
     *        The constructor of the class which initializes the clan ID
     */
    public BalgaClan(int clanID) {
        super("BalgaClan", clanID);

        //Initialize the four types of action point deciders where the simple deciders deliver typical maximum/non-
        //iterative damage while the angry and selfless heal or deal damage more aggressively while taking extra damage
        zacWDecider = new ZacWarriorDecider(10);
        zacHDecider = new ZacHealerDecider(10);


    }

    /**
     *
     * @param hitPoints the number of hit points to be distributed amongst all the clan members
     * @return a list of all the members in a clan
     *
     */
    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {


        int totalHP = hitPoints;
        int unassignedHP = hitPoints;

        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        if (totalHP < 5000) {
            while (unassignedHP > 0) {
                int nextWarriorHPAssignment = 70;
                if (unassignedHP < 70) {
                    nextWarriorHPAssignment = unassignedHP;
                }
                clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextWarriorHPAssignment, zacWDecider));

                unassignedHP -= nextWarriorHPAssignment;
            }

            while (unassignedHP > 0) {
                int nextHealerHPAssignment = 30;
                if (unassignedHP < 30) {
                    nextHealerHPAssignment = unassignedHP;
                }
                clanMembers.add(new ClanMember(getClanID(), HEALER, nextHealerHPAssignment, zacHDecider));

                unassignedHP -= nextHealerHPAssignment;
            }
        }
        else {
            while (unassignedHP > 0) {
                int nextWarriorHPAssignment = 5000;
                if (unassignedHP < 5000) {
                    nextWarriorHPAssignment = unassignedHP;
                }
                clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextWarriorHPAssignment, zacWDecider));

                unassignedHP -= nextWarriorHPAssignment;
            }

            while (unassignedHP > 0) {
                int nextHealerHPAssignment = 5000;
                if (unassignedHP < 5000) {
                    nextHealerHPAssignment = unassignedHP;
                }
                clanMembers.add(new ClanMember(getClanID(), HEALER, nextHealerHPAssignment, zacHDecider));

                unassignedHP -= nextHealerHPAssignment;
            }
        }

        return clanMembers;
    }
}

