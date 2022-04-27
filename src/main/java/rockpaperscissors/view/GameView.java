package rockpaperscissors.view;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import rockpaperscissors.Game;
import rockpaperscissors.Round;

/**
 *
 * @author omihalyi
 */
@Named("game")
@SessionScoped
public class GameView implements Serializable {

    private Game game;

    @PostConstruct
    public void init() {
        game = new Game();
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
