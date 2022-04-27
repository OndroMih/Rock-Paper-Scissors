package rockpaperscissors.view;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
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
    
    private Game game;

    @PostConstruct
    public void init() {
        game = new Game(store);
    }

    public void playRound() {
        game.playRound();
    }

    public int getRoundsPlayedByUser() {
        return game.numberOfRoundsForCurrentUser();
    }

    public List<Round> getRounds() {
        return game.getRounds().collect(Collectors.toList());
    }
    
    public void restart() {
        game.restart();
    }

}
