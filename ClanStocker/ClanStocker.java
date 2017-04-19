package clanmelee.ClanStocker;


import clanmelee.ClanMember;
import clanmelee.Clan;

import java.util.ArrayList;

public class ClanStocker extends Clan{

    public ClanStocker(int clanID) {
        super("ClanStocker", clanID);
    }

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> fullClanMembers = new ArrayList<>();

        SpookedTankMemeber spTank = new SpookedTankMemeber(getClanID());
        DrLuigiHealerMember drHealer = new DrLuigiHealerMember(getClanID());
        WarriorWarriorMember wWarrior = new WarriorWarriorMember(getClanID());

        fullClanMembers.addAll(spTank.getClanMembers(hitPoints));
        fullClanMembers.addAll(drHealer.getClanMembers(hitPoints));
        fullClanMembers.addAll(wWarrior.getClanMembers(hitPoints));


        return fullClanMembers;

    }
}
