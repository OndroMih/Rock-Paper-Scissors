package rockpaperscissors;

/**
 *
 * @author omihalyi
 */
public class Round {
    private PlayersMove moveByPlayer1;
    private PlayersMove moveByPlayer2;

    public Round(PlayersMove moveByPlayer1, PlayersMove moveByPlayer2) {
        this.moveByPlayer1 = moveByPlayer1;
        this.moveByPlayer2 = moveByPlayer2;
    }

    public PlayersMove getMoveByPlayer1() {
        return moveByPlayer1;
    }

    public PlayersMove getMoveByPlayer2() {
        return moveByPlayer2;
    }

}
