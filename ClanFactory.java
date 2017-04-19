package clanmelee;

import clanmelee.Balga.BalgaClan;
import clanmelee.Clan1.Clan1;
import clanmelee.Clan2.Clan2;
import clanmelee.ClanHaug.ClanHaug;
import clanmelee.Stocker.ClanStocker;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Class that creates the Clans that will be in the battle.
 */
public class ClanFactory {

    /**
     * Creates ArrayList of with the amount of clans wanted in battle.
     * @return ArrayList of clans created.
     */
    public Collection<Clan> getClans() {
        ArrayList<Clan> clans = new ArrayList<>();

        int clanID = 0;

        clans.add(new Clan1(clanID++));
        clans.add(new Clan2(clanID++));
        clans.add(new ClanStocker(clanID++));
        clans.add(new BalgaClan(clanID++));
        clans.add(new ClanHaug(clanID++));


        return clans;
    }
}
