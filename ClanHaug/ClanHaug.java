package clanmelee.ClanHAUUUUG;

import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

public class ClanHAUUUUG extends Clan {

    public ClanHAUUUUG(int clanID) {
        super("ClanHAUUUUG", clanID);
    }
    /**
     * This class serves as the main factory which brings together all clan member types into a final list.
     */
    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {

        ArrayList<ClanMember> fullClanMembers = new ArrayList<>();

        LEEEEROOOOYJENKINSMember ljm = new LEEEEROOOOYJENKINSMember(getClanID());
        DodgeTankMember dtm = new DodgeTankMember(getClanID());

        fullClanMembers.addAll(ljm.getClanMembers(hitPoints));
        fullClanMembers.addAll(dtm.getClanMembers(hitPoints));

        return fullClanMembers;
    }
}
