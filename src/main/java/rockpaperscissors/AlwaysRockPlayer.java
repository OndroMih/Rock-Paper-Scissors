package rockpaperscissors;

/**
 *
 * @author omihalyi
 */
public class AlwaysRockPlayer extends Player {

    @Override
    public PlayersMove move() {
        return PlayersMove.ROCK;
    }
    
}
