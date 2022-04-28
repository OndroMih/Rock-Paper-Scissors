package rockpaperscissors.view;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import rockpaperscissors.Game;
import rockpaperscissors.Round;
import rockpaperscissors.store.DataStore;

/**
 *
 * @author omihalyi
 */
@Named("game")
@RequestScoped
public class GameView {

    @Inject
    private DataStore store;
    
    @Inject
    private Game game;

    public void playRound() {
        game.playRound();
    }

    public int getRoundsPlayedByUser() {
        return game.numberOfRoundsForCurrentUser();
    }

    public List<Round> getRounds() {
        final List<Round> rounds = game.getRounds().collect(Collectors.toList());
        Collections.reverse(rounds);
        return rounds;
    }
    
    public void restart() {
        game.restart();
    }

}
