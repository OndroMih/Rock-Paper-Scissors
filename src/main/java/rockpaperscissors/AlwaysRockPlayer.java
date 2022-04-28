package rockpaperscissors;

/**
 * Player which always chooses Rock move
 * @author omihalyi
 */
public class AlwaysRockPlayer extends Player {

    @Override
    public PlayersMove move() {
        return PlayersMove.ROCK;
    }
    
}
