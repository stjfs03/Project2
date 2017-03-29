package clanmelee;

public class ClanStats {
    /**
     * @param totalClanCount - total number of clans in the melee
     * @param hitPoints - array of total hitpoints in each clan
     * @param playerCounts - array of total players
     * @param warriorCounts -
     * @param healerCounts -
     *
     */
    private final int totalClanCount;
    private int[] hitPoints;
    private int[] playerCounts;
    private int[] warriorCounts;
    private int[] healerCounts;

    /**
     * Constructor
     *
     * @param clanCount -
     */
    public ClanStats(int clanCount) {
        this.totalClanCount = clanCount;
        this.hitPoints = new int[clanCount];
        this.playerCounts = new int[clanCount];
        this.warriorCounts = new int[clanCount];
        this.healerCounts = new int[clanCount];
    }

    /**
     *
     * @param cm - adds ClanMember to clan
     *
     * This method
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */
    public void addPlayer(ClanMember cm) {
        int clanID = cm.getClanID();
        hitPoints[clanID] += cm.getHitPoints();
        playerCounts[clanID] += 1;
        if (cm.getType() == ClanMember.ClanMemberType.HEALER)
            healerCounts[clanID] += 1;
        else if (cm.getType() == ClanMember.ClanMemberType.WARRIOR)
            warriorCounts[clanID] += 1;
    }

    /**
     *
     *
     * @param clanID
     * @return
     */
    public int getHitPoints(int clanID) {
        return hitPoints[clanID];
    }

    /**
     *
     *
     * @param clanID
     * @return
     */
    public int getPlayerCount(int clanID) {
        return playerCounts[clanID];
    }

    /**
     *
     *
     * @param clanID
     * @return
     */
    public int getWarriorCount(int clanID) {
        return warriorCounts[clanID];
    }

    /**
     *
     *
     * @param clanID
     * @return
     */
    public int getHealerCount(int clanID) {
        return healerCounts[clanID];
    }

    /**
     *
     *
     * @return
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
     *
     *
     * @return
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
