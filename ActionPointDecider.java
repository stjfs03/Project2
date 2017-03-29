package clanmelee;

/**
 * Classes that implement ActionPointDecider can be used to define a ClanMember's strategy
 */
public interface ActionPointDecider {
    /**
     *
     * @param player    the ClanMember doing the deciding
     * @param target the ClanMember that the player is interacting
     * @return      the number of points to attack or heal with. 0 or less to run away.
     */
    public int decideActionPoints(ClanMember player, ClanMember target);
}
