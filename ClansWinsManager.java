package clanmelee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * This class add wins to the winning clan from arraylist of all the competing clans
 */
public class ClansWinsManager {
    private HashMap<Integer, IndividualClanWins> clansWins = new HashMap<>();
    private int maxNameWidth = 0;

    /**
     * Get the total number of clans contained in clansWins
     * @return returns the number of clans contained in clansWins
     */
    public int clanCount() {
        return clansWins.size();
    }

    /**
     * Adds a clan to the clansWins Hashmap
     * @param clanID The number used to Identify specific clans
     * @param clanName The name of the clan
     */
    public void addClan(int clanID, String clanName) {
        clansWins.put(clanID, new IndividualClanWins(clanName));
        if (clanName.length() > maxNameWidth)
            maxNameWidth = clanName.length();
    }

    /**
     * Adds a win for the Clan and adds it to clanWins
     * @param victorID The clan ID of the clan that won
     */
    public void addWin(int victorID) {
        clansWins.get(victorID).addWin();
    }

    /**
     *Prints the name of the clan and the number of wins they each have, displayed a fancy table
     */
    public void print() {
        ArrayList<IndividualClanWins> arrayWins = new ArrayList<>();
        arrayWins.addAll(clansWins.values());
        Collections.sort(arrayWins);
        String line = "+";
        for (int i = 0; i < maxNameWidth + 6; i++)
            line += "-";
        line += "+";
        System.out.println(line);
        for (IndividualClanWins wins : arrayWins) {
            System.out.println(String.format("| %" + maxNameWidth + "s: %-3s|",
                    wins.getName(), wins.getWins()));
        }
        System.out.println(line);
    }
}
