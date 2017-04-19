package clanmelee.Obrien;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.HEALER;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;


/**
 * Created by Nemo on 4/18/17.
 */
public class ObrienClan extends Clan {

    private ActionPointDecider obrienHealerDecider;
    private ActionPointDecider obrienWarriorDecider;


    public ObrienClan(int clanID) {
        super("ObrienClan", clanID);

        obrienHealerDecider = new ObrienHealerDecider(10);
        obrienWarriorDecider = new ObrienWarriorDecider(10);

    }

    /**
     *
     * @param hitPoints the number of hit points to be distributed amongst all the clan members
     * @return a list of all the members in a clan
     *
     */
    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {

        int nextHpAssignment;
        int totalHP = hitPoints;
        int unassignedHP = hitPoints;

        ArrayList<ClanMember> clanMembers = new ArrayList<>();




            while (unassignedHP > 0) {
                nextHpAssignment = totalHP/10;
                if (unassignedHP < totalHP/10) {
                    nextHpAssignment = unassignedHP;
                }

                if (Math.random() > 0.5) {
                    if (Math.random() > 0.5) {
                        clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextHpAssignment, obrienWarriorDecider));
                    }

                    else {
                        clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextHpAssignment, obrienWarriorDecider));
                    }
                }

                else {
                    if (Math.random() > 0.5) {
                        clanMembers.add(new ClanMember(getClanID(), HEALER, nextHpAssignment, obrienHealerDecider));
                    }

                    else{
                        clanMembers.add(new ClanMember(getClanID(), HEALER, nextHpAssignment, obrienHealerDecider));
                    }
                }

                unassignedHP -= nextHpAssignment;
            }






        return clanMembers;
    }

}
