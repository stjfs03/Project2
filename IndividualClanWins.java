package clanmelee;

/**
 * This class deals with the wins of a single clan
 */
public class IndividualClanWins implements Comparable<IndividualClanWins> {
    private String name;
    private Integer wins;


    /**
     * instantiates the private variables
     * @param name The name of the clan
     */
    public IndividualClanWins(String name) {
        this.name = name;
        this.wins = 0;
    }


    /**
     * Adds a win to the total number of wins
     */
    public void addWin() {
        wins += 1;
    }

    /**
     * Get the name of the clan
     * @return returns the name of the clan
     */
    public String getName() {
        return name;
    }

    /**
     * Get the total number of wins for the clan
     * @return the total number of wins for the clan
     */
    public int getWins() {
        return wins;
    }

    /**
     *
     * @param other the IndividualClanWins of another clan
     * @return the compared value of wins
     */
    @Override
    public int compareTo(IndividualClanWins other) {
        return wins.compareTo(other.getWins()) * -1;
    }
}
