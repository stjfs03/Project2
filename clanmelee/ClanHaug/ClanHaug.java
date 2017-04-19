package clanmelee.ClanHaug;

import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

public class ClanHaug extends Clan {

    public ClanHaug(int clanID) {
        super("ClanHaug", clanID);
    }
    /**
     * This class serves as the main factory which brings together all clan member types into a final list.
     */
    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {

        int leeroyHealth = (int)(hitPoints*.24);
        int dodgeHealth = (int)(hitPoints*.75);
        int frailHealth = (int)(hitPoints*.001);
        int meatyHealth = (int)(hitPoints*.009);

        ArrayList<ClanMember> fullClanMembers = new ArrayList<>();

        LEEEEROOOOYJENKINSMember ljm = new LEEEEROOOOYJENKINSMember(getClanID());
        DodgeTankMember dtm = new DodgeTankMember(getClanID());
        FrailHealerMember fhm = new FrailHealerMember(getClanID());
        MeatyHealerMember mhm = new MeatyHealerMember(getClanID());

        fullClanMembers.addAll(ljm.getClanMembers(leeroyHealth));
        fullClanMembers.addAll(dtm.getClanMembers(dodgeHealth));
        fullClanMembers.addAll(fhm.getClanMembers(frailHealth));
        fullClanMembers.addAll(mhm.getClanMembers(meatyHealth));

        return fullClanMembers;
    }
}
