package rockpaperscissors;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author omihalyi
 */
public class Game {

    List<Round> rounds = new ArrayList<>();
    Player player1 = new Player();
    Player player2 = new Player();
    
    public int numberOfRoundsForCurrentUser() {
        return rounds.size();
    }

    public int roundsPlayed() {
        return rounds.size();
    }
    
    public void playRound() {
        addRound(new Round(player1.move(), player2.move()));
    }

    private void addRound(Round round) {
        rounds.add(round);
    }
    
}
