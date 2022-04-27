package rockpaperscissors;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author omihalyi
 */
public class RandomPlayer extends Player {

    @Override
    public PlayersMove move() {
        int randomIndex = new Random().nextInt(PlayersMove.values().length);
        return PlayersMove.values()[randomIndex];
    }
    
}
