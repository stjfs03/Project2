package clanmelee;

/**
 * All clan members are of this class. Each clan member's strategy is defined
 * by its ActionPointDecider
 */
public class ClanMember {

    /**
     * Each clan member can either be a Warrior or a Healer; nothing else
     */
    public enum ClanMemberType {WARRIOR, HEALER};

    /**
     * Represents what Clan the ClanMember is a part of.
     */
    private final int clanID;

    /**
     * the type of member the ClanMember is; ie. Warrior or Healer.
      */
    private final ClanMemberType type;

    /**
     * The maximum number of Hit Points a ClanMember can have at any one time
     */
    private int maxHitPoints;

    /**
     * The highest input someone can input for maxHitPoints.
     */
    public static final int HIT_POINT_CAP = 1000;

    /**
     * The current number of Hit Points a ClanMember has.
     * Each clan member starts off with hitPoints == maxHitPoints.
     * Attack damage decreases hitPoints.
     * Iteration damage decreases both hitPoints and maxHitPoints.
     */
    private int hitPoints;

    // number of action points that do not cost additional iteration damage
    public static final int FREE_ACTION_POINTS = 10;

    // number of extra action points which cost a single iteration damage point
    public static final int ACTION_POINTS_PER_ITERATION_DAMAGE_POINT = 2;

    // Decides whether to act or to run away,
    // if they act decides how many points to attack or heal with.
    private ActionPointDecider decider;

    /**
     *
     * Constructor
     *
     * @param clanID     the member's clan's unique clan ID
     * @param type       ClanMemberType.WARRIOR or ClanMemberType.HEALER
     * @param hitPoints  Sets the maximum number of Hit Points and starting Hit Points
     * @param decider    implements the Clan Member's strategy
     */
    public ClanMember(int clanID, ClanMemberType type, int hitPoints,
                      ActionPointDecider decider) {
        this.clanID = clanID;
        this.type = type;
        this.decider = decider;

        // Forces the Hit Point Cap to to equal HIT_POINT_CAP if the input was greater then HIT_POINT_CAP (1000)
        if (hitPoints > HIT_POINT_CAP)
            this.maxHitPoints = HIT_POINT_CAP;
        else
            this.maxHitPoints = hitPoints;

        this.hitPoints = this.maxHitPoints;
    }

    /**  Get the clan ID passed to the constructor  */
    public int getClanID() {
        return clanID;
    }

    /**  Get the clan member type passed to the contructor  */
    public ClanMemberType getType() {
        return type;
    }

    /**  Get the clan member's current number of hit points  */
    public int getHitPoints() {
        return hitPoints;
    }

    /**  Get the clan member's maximum number of hit points  */
    public int getMaxHitPoints() {
        return maxHitPoints;
    }


    /**
     * Public way to get action points. Ensures no more than the max allowed
     * action points are returned.
     *
     * @param other the clan member that this clan member is up against
     * @return      the number of points to attack or heal with. 0 to run away.
     */

    public int getActionPoints(ClanMember other) {
        int actionPoints = decider.decideActionPoints(this, other);

        // the most action points this clan member can afford in hit points
        int maxActionPoints = hitPoints * ACTION_POINTS_PER_ITERATION_DAMAGE_POINT
                + FREE_ACTION_POINTS; // ((Hit Points*2) + 10);

        // sets actionPoints to maxActionPoints if actionPoints is greater then maxActionPoints
        if (actionPoints > maxActionPoints)
            actionPoints = maxActionPoints;


        dealIterationDamage(actionPoints);

        return actionPoints;
    }

    /**
     * Self-inflict the action point damage and decrease max hit points by 1
     *
     * @param actionPoints number of action points dealt this iteration
     */
    public void dealIterationDamage(int actionPoints) {

        if (actionPoints > FREE_ACTION_POINTS) {

            int damage = (actionPoints - FREE_ACTION_POINTS - 1) / ACTION_POINTS_PER_ITERATION_DAMAGE_POINT + 1;
            // (action points - 10-1)/(2+1)

            // Inflicts damage to this clan members Hit Points
            dealDamage(damage);
        }

        maxHitPoints -= 1;
        if (hitPoints > maxHitPoints)
            hitPoints = maxHitPoints;
    }

    /**
     * Heal the clan member by a certain number of points.
     * The clan member's hit points will not exceed their maximum hit point limit
     *
     * @param healPoints number of points to heal by
     */
    public void heal(int healPoints) {
        hitPoints += healPoints;
        if (hitPoints > maxHitPoints)
            hitPoints = maxHitPoints;
    }

    /**
     * Decrease the clan member's hit points by a certain number of points.
     * Will not decrease the number of hit points below 0
     *
     * @param damagePoints number of points of damage
     */
    public void dealDamage(int damagePoints) {
        hitPoints -= damagePoints;
        if (hitPoints < 0)
            hitPoints = 0;
    }

    /**
     * @return true if the clan member has more than 0 hit points, otherwise it will return false
     */
    public boolean isAlive() {
        return hitPoints != 0;
    }
}
