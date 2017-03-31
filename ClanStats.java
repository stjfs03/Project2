package clanmelee;

public class ClanStats {
    /**
     * @param totalClanCount - total number of clans in the melee
     * @param hitPoints - array of total hitpoints per clan
     * @param playerCounts - array of total players in each clan
     * @param warriorCounts - array of total warriors within each clan
     * @param healerCounts - array of total healers within each clan
     */
    private final int totalClanCount;
    private int[] hitPoints;
    private int[] playerCounts;
    private int[] warriorCounts;
    private int[] healerCounts;

    /**
     * Constructor
     *
     * @param clanCount - Represents the number of clans in the melee
     */
    public ClanStats(int clanCount) {
        this.totalClanCount = clanCount;
        this.hitPoints = new int[clanCount];
        this.playerCounts = new int[clanCount];
        this.warriorCounts = new int[clanCount];
        this.healerCounts = new int[clanCount];
    }

    /**
     * @param p - Adds a ClanMember object to clan
     *
     * This method assigns the clan member object a clanID,
     * adds that member's hitpoints to the clan's hitpoint array,
     * updates the clan's player count array, and updates the
     * number of healers and warriors in the respective clan
     * arrays
     */
    public void addPlayer(ClanMember p) {
        int clanID = p.getClanID();
        hitPoints[clanID] += p.getHitPoints();
        playerCounts[clanID] += 1;
        if (p.getType() == ClanMember.ClanMemberType.HEALER)
            healerCounts[clanID] += 1;
        else if (p.getType() == ClanMember.ClanMemberType.WARRIOR)
            warriorCounts[clanID] += 1;
    }

    /**
     * @param clanID - A clan's unique ID
     * @return - The total hit points of a certain clan
     */
    public int getHitPoints(int clanID) {
        return hitPoints[clanID];
    }

    /**
     * @param clanID - A clan's unique ID
     * @return - The number of players (members) in a certain clan
     */
    public int getPlayerCount(int clanID) {
        return playerCounts[clanID];
    }

    /**
     * @param clanID - A clan's unique ID
     * @return - The number of warriors in a clan
     */
    public int getWarriorCount(int clanID) {
        return warriorCounts[clanID];
    }

    /**
     * @param clanID - A clan's unique ID
     * @return The number of healers in a clan
     */
    public int getHealerCount(int clanID) {
        return healerCounts[clanID];
    }

    /**
     * @return - The number of active clans (clans with more than 0 members)
     */
    public int getClanCount() {
        int clanCount = 0;
        for (int i = 0; i < totalClanCount; i++) {
            if (playerCounts[i] != 0)
                clanCount += 1;
        }
        return clanCount;
    }

    /**
     * @return - The winning clan (the clan with the most total hp)
     */
    public int getWinner() {
        int max = 0;
        int maxID = 0;

        for (int i = 0; i < totalClanCount; i++) {
            if (hitPoints[i] > max) {
                max = hitPoints[i];
                maxID = i;
            }
        }

        return maxID;
    }
}
