package clanmelee.Spirk;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;
import java.util.ArrayList;
import static clanmelee.ClanMember.ClanMemberType.HEALER;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

public class JediKnightMember extends Clan {

        public JediKnightMember(int clanID) {
            super("Jedi Knight", clanID);
        }

        @Override
        public ArrayList<ClanMember> getClanMembers(int hitPoints) {
            ArrayList<ClanMember> clanMembers = new ArrayList<>();

            ActionPointDecider decider = new JediKnightDecider(12);

            int adjHitPoints = (int)(hitPoints * .30);
            while (adjHitPoints > 0) {
                int nextHP = 100;
                if (adjHitPoints < 100)
                    nextHP = adjHitPoints;

                clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextHP, decider));
                adjHitPoints -= nextHP;
            }
            return clanMembers;
        }
}
