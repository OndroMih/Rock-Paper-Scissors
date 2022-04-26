package rockpaperscissors;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author omihalyi
 */
public class Game {

    private List<Round> rounds = new ArrayList<>();
    private Player player1 = new Player();
    private Player player2 = new Player();
    
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

    public Stream<Round> getRounds() {
        return rounds.stream();
    }
    
}
