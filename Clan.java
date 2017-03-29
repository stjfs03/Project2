package clanmelee;

import java.util.Collection;

/**
 * A factory that produces ClanMember objects for one particular clan
 */
public abstract class Clan {
    private final String clanName;
    private final int clanID;

    /**
     * @Purpose: Constructor that creates a clan
     *
     * @param: clanName name of the clan
     * @param: clanID   the clan's unique ID
     *
     * @return: None (Is a constructor).
     */
    public Clan(String clanName, int clanID) {
        this.clanName = clanName;
        this.clanID = clanID;
    }

    /**
     * @Purpose: Gets the clan ID
     *
     * @param: None
     *
     * @Return: The clan ID.
     */
    public int getClanID() {
        return clanID;
    }

    /**
     * @Purpose: Gets the clan name.
     *
     * @Param: None
     *
     * @Return: The clan's name.
     */
    public String getClanName() {
        return clanName;
    }

    /**
     * @Purpose: Concrete clans implement this factory method to produce clan members
     *
     * @param hitPoints the number of hit points to be distributed amongst all the clan members
     * @return the clan's members
     */
    public abstract Collection<ClanMember> getClanMembers(int hitPoints);
}
