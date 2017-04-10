package clanmelee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static clanmelee.ClanMember.ClanMemberType.HEALER;

public class ClanMelee {
    // Manages the Clan Wins of the Clans in the Melee
    ClansWinsManager clansWins = new ClansWinsManager();

    /**
     * Begins the Melee
     *
     * @param clans the Clans in the Melee
     * @param hitPoints the amount of hitpoints each ClanMember begins with in the Melee
     */
    public void runMelee(Collection<Clan> clans, int hitPoints) {
        ArrayList<ClanMember> participants = new ArrayList<>();
        int totalClanCount = clans.size();
        String[] clanNames = new String[totalClanCount];
        ClanStats clanStats = new ClanStats(totalClanCount);


        validateAllClans(clans, hitPoints, clanNames, participants, clanStats);



        int clanCount = totalClanCount;
        boolean[] previouslyAlive = new boolean[totalClanCount];
        Arrays.fill(previouslyAlive, true);
        int roundCount = 0;

        runBattle(clanCount, participants, clanStats, totalClanCount, roundCount, previouslyAlive, clanNames);
    }

    /**
     * Begins the battle
     *
     * @param clanCount the amount of Clans currently in the Melee
     * @param participants the ClanMembers in the Melee
     * @param clanStats the stats of the Clans
     * @param totalClanCount the amount of Clans in the Melee
     * @param roundCount the current round of the Battle
     * @param previouslyAlive the ClanMembers that are dead
     * @param clanNames the names of the Clans
     */
    public void runBattle(int clanCount, ArrayList<ClanMember> participants,
                          ClanStats clanStats, int totalClanCount, int roundCount,
                          boolean[] previouslyAlive, String[] clanNames) {

        while (clanCount > 1) {
            Collections.shuffle(participants);
            clanStats = new ClanStats(totalClanCount);
            boolean[] currentlyAlive = new boolean[totalClanCount];
            Arrays.fill(currentlyAlive, false);
            ArrayList<ClanMember> remaining = new ArrayList<>(participants.size());


            runRound(participants, currentlyAlive, remaining, clanStats);

            checkForLastParticipant(participants, clanStats, currentlyAlive, remaining);

            clanCount = clanStats.getClanCount();

            roundCount += 1;

            checkForClanElimination(totalClanCount, currentlyAlive, previouslyAlive, clanNames, roundCount);

            previouslyAlive = currentlyAlive;

            participants = remaining;
        }

        if (clanCount == 0) {
            System.out.println("All were slain after " + roundCount
                    + " interactions!");
        }
        else {
            declareWinner(clanNames, roundCount, clanStats);
        }

    }

    /**
     * Runs one round of the Melee
     *
     * @param participants the ClanMembers in the Melee
     * @param membersCurrentlyAlive the ClanMembers that are alive
     * @param remainingParticipants the ClanMembers that are still in the Melee
     * @param clanStats the stats of the Clans
     */
    public void runRound(ArrayList<ClanMember> participants,
                         boolean[] membersCurrentlyAlive,
                         ArrayList<ClanMember> remainingParticipants, ClanStats clanStats) {

        for (int i = 0; i < participants.size() - 1; i += 2) {
            ClanMember p1 = participants.get(i);
            ClanMember p2 = participants.get(i + 1);

            runInteraction(p1, p2);

            if (p1.isAlive()) {
                clanStats.addPlayer(p1);
                membersCurrentlyAlive[p1.getClanID()] = true;
                remainingParticipants.add(p1);
            }
            if (p2.isAlive()) {
                clanStats.addPlayer(p2);
                membersCurrentlyAlive[p2.getClanID()] = true;
                remainingParticipants.add(p2);
            }
        }
    }


    /**
     * Declares the winner of the Melee
     *
     * @param clanNames The names of the Clans
     * @param roundCount The current round of the Melee
     * @param clanStats the ClanStat to get the winner of the Melee
     */
    public void declareWinner(String[] clanNames, int roundCount, ClanStats clanStats) {
        int victorID = clanStats.getWinner();
        System.out.println(clanNames[victorID] + " emerged victorious after " +
                roundCount + " interactions!");
        clansWins.addWin(victorID);
    }

    /**
     * Checks to see if there is only one ClanMember left in the Melee
     *
     * @param participants the ClanMembers in the Melee
     * @param clanStats The stats of the Clans
     * @param currentlyAlive an array for telling whether a ClanMember is alive or dead
     * @param remaining the remain ClanMembers in the Melee
     */
    public void checkForLastParticipant(ArrayList<ClanMember> participants, ClanStats clanStats,
                                        boolean[] currentlyAlive, ArrayList<ClanMember> remaining) {
        if (participants.size() % 2 == 1) {
            ClanMember lastPlayer = participants.get(participants.size() - 1);
            int lastID = lastPlayer.getClanID();
            lastPlayer.dealIterationDamage(0);
            if (lastPlayer.isAlive()) {
                clanStats.addPlayer(lastPlayer);
                currentlyAlive[lastID] = true;
                remaining.add(lastPlayer);
            }
        }
    }

    /**
     *  Checks to see if any clan has been eliminated
     *
     * @param totalClanCount the total number of Clans in the Melee
     * @param currentlyAlive the list of ClanMembers that are currently alive
     * @param previouslyAlive the list of ClanMembers that are dead
     * @param clanNames the names of the Clans
     * @param roundCount the current round the Melee is in
     */
    public void checkForClanElimination(int totalClanCount, boolean[] currentlyAlive,
                                        boolean[] previouslyAlive, String[] clanNames, int roundCount) {
        for (int i = 0; i < totalClanCount; i++) {
            if (!currentlyAlive[i] && previouslyAlive[i]) {
                if (clanNames[i] == null)
                    continue;
                System.out.println(clanNames[i] + " eliminated after " +
                        roundCount + " interactions");
            }
        }
    }


    /**
     * initiates combat between two ClanMembers
     *
     * @param p1 the initiator of combat
     * @param p2 the target of p1
     */
    private void runInteraction(ClanMember p1, ClanMember p2) {
        int p1Action = p1.getActionPoints(p2);
        int p2Action = p2.getActionPoints(p1);

        applyAction(p1, p1Action, p2, p2Action);
        applyAction(p2, p2Action, p1, p1Action);
    }

    /**
     *
     *
     * @param p1 the initiator of the combat
     * @param p1Action the amount of actionPoints p1 uses
     * @param p2 the target of p1
     * @param p2Action the amount of actionPoints p2 has
     */
    private void applyAction(ClanMember p1, int p1Action,
                             ClanMember p2, int p2Action) {
        if (p1.getType() == HEALER)
            p2.heal(p1Action);
        else {
            if (p2Action > 0 || Math.random() < 0.5)
                p2.dealDamage(p1Action);
        }
    }

    /**
     * prints the stats of the Clans
     */
    void printStats() {
        clansWins.print();
    }

    /**
     * Validates a single Clan
     *
     * @param members the members in the Clan
     * @param hitPoints the number of hitPoints that each ClanMember has
     * @param clanID the id of the Clan
     * @param clanName the name of the Clan
     * @return true if the Clan passes the validation or false if the Clan fails the validation
     */
    private boolean validateClan(Collection<ClanMember> members, int hitPoints,
                                 int clanID, String clanName) {
        int hitPointSum = 0;
        for (ClanMember cm : members) {
            if (cm.getClanID() != clanID) {
                System.out.println(clanName + " does not have consistent clan IDs!!");
                System.out.println(clanName + " DISQUALIFIED!!");
                return false;
            }
            hitPointSum += cm.getMaxHitPoints();
        }
        if (hitPointSum > hitPoints) {
            System.out.println(clanName + " has " + hitPointSum +
                    " hit points when only " + hitPoints + " are allowed!!");
            System.out.println(clanName + " DISQUALIFIED!!");
            return false;
        }
        return true;
    }

    /**
     * This method validates all the Clans in the Melee
     *
     * @param clans All the Clans in the Melee
     * @param hitPoints The amount of hitpoints the clan members have
     * @param clanNames List of all the clan names
     * @param participants List of all the participants in the Melee
     * @param clanStats The clan stats of the individual clans
     */
    public void validateAllClans(Collection<Clan> clans, int hitPoints, String[] clanNames,
                                 ArrayList<ClanMember> participants, ClanStats clanStats) {
        for (Clan clan : clans) {
            int clanID = clan.getClanID();
            String clanName = clan.getClanName();
            if (clansWins.clanCount() < clans.size())
                clansWins.addClan(clanID, clanName);
            Collection<ClanMember> members = clan.getClanMembers(hitPoints);
            if (!validateClan(members, hitPoints, clanID, clan.getClanName()))
                continue;
            clanNames[clanID] = clan.getClanName();
            participants.addAll(members);
            for (ClanMember member : members)
                clanStats.addPlayer(member);
        }
    }
}

