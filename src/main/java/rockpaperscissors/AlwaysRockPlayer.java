package rockpaperscissors;

import java.io.Serializable;

/**
 *
 * @author omihalyi
 */
public class AlwaysRockPlayer extends Player implements Serializable {

    @Override
    public PlayersMove move() {
        return PlayersMove.ROCK;
    }
    
}
