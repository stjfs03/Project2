package clanmelee;

public class ClanWins implements Comparable<ClanWins> {
    private String name;
    private Integer wins;

    public ClanWins(String name) {
        this.name = name;
        this.wins = 0;
    }

    // increments the private variable wins by 1.
    public void addWin() {
        wins += 1;
    }

    // returns the private variable name.
    public String getName() {
        return name;
    }

    // returns the private variable wins.
    public int getWins() {
        return wins;
    }


    @Override
    public int compareTo(ClanWins other) {
        return wins.compareTo(other.getWins()) * -1;
    }
}
