package rockpaperscissors;

import java.util.Random;

/**
 * Player which chooses random moves.
 * @author omihalyi
 */
public class RandomPlayer extends Player {

    @Override
    public PlayersMove move() {
        int randomIndex = new Random().nextInt(PlayersMove.values().length);
        return PlayersMove.values()[randomIndex];
    }
    
}
