package clanmelee.Spirk;

import clanmelee.Clan;
import clanmelee.ClanMember;
import java.util.ArrayList;

public class SpirkClan extends Clan {

    public SpirkClan(int clanID) {
        super("SpirkClan", clanID);
    }

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> fullClanMembers = new ArrayList<>();

        ConfusedHealerMember conHealer = new ConfusedHealerMember(getClanID());
        MedicHunterMember medHunter = new MedicHunterMember(getClanID());
        JediKnightMember jediKnight = new JediKnightMember(getClanID());
        DarthPlagueisTheWiseMember sithLord = new DarthPlagueisTheWiseMember(getClanID());

        fullClanMembers.addAll(conHealer.getClanMembers(hitPoints));
        fullClanMembers.addAll(medHunter.getClanMembers(hitPoints));
        fullClanMembers.addAll(jediKnight.getClanMembers(hitPoints));
        fullClanMembers.addAll(sithLord.getClanMembers(hitPoints));

        return fullClanMembers;
    }
}
