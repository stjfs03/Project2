package clanmelee.Sobrino;

import clanmelee.Clan;

/**
 * Created by mariosobrino on 4/18/17.
 */

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.Clan;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.WARRIOR;
import static clanmelee.ClanMember.ClanMemberType.HEALER;


public class SobrinoClan extends Clan {

    private ActionPointDecider braveDecider;
    private ActionPointDecider doctorDecider;
    private ActionPointDecider assistantDecider;
    private ActionPointDecider regularDecider;

    public SobrinoClan(int clanID){

        super("SobrinoClan", clanID);

        braveDecider = new BraveWarriorDecider(10);
        doctorDecider = new DoctorDecider(10);
        assistantDecider = new DoctorAssistantDecider(10);
        regularDecider = new RegularWarriorDecider(10);



    }

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints){


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
                    clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextHpAssignment, braveDecider));
                }

                else {
                    clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextHpAssignment, regularDecider));
                }
            }

            else {
                if (Math.random() > 0.5) {
                    clanMembers.add(new ClanMember(getClanID(), HEALER, nextHpAssignment, doctorDecider));
                }

                else{
                    clanMembers.add(new ClanMember(getClanID(), HEALER, nextHpAssignment, assistantDecider));
                }
            }

            unassignedHP -= nextHpAssignment;
        }

        return clanMembers;



    }




}
