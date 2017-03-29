package clanmelee;

/**
 * Classes implement ActionPointDecider which can be used to define a ClanMember's strategy
 */
public interface ActionPointDecider {
    /**
     *
     * @param player    the player who's turn it is
     * @param target the character that the player wants to interact with
     * @return      the magnitude of an action (attacking or healing) . A player runs away if Action points are 0 or
     *              less.
     */
    public int decideActionPoints(ClanMember player, ClanMember target);


}
