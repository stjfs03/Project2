package clanmelee;

import java.util.Collection;
import java.util.Random;

// Class that runs the actual simulation of Clan Melee.
public class Main {

    private static Random rand = new Random();

    // Is used to determine the number of base hit points for a clan
    private static int determineHitPoints(int original) {
        int amount = rand.nextInt((int) (original * 0.05));
        if (rand.nextDouble() < 0.5)
            return original + amount;
        else
            return original - amount;
    }

    // Runs the actual simulation of Clan Melee where each round's results are printed out for display.
    // All Clans, hit points, members, and battle is created and run.
    public static void main(String[] args) {
        int[] allBaseHitPoints = {100, 1000, 10000, 100000, 1000000, 10000000};
        Collection<Clan> clans = new ClanFactory().getClans();
        ClanMelee melee = new ClanMelee();
        int round = 1;
        for (int baseHitPoints : allBaseHitPoints) {
            for (int i = 0; i < 5; i++) {
                int hitPoints = determineHitPoints(baseHitPoints);

                System.out.println("Round " + round + ", " + hitPoints
                        + " hit points per clan");
                System.out.println();

                melee.runMelee(clans, hitPoints);

                System.out.println();
                System.out.println("Results after " + round + " rounds:");
                melee.printStats();
                System.out.println();

                ++round;
            }
        }
    }
}
