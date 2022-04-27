package rockpaperscissors;

import java.io.Serializable;

/**
 *
 * @author omihalyi
 */
public class Round implements Serializable {
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
    
    public RoundResult getResult() {
        return moveByPlayer1.compareAgainst(moveByPlayer2);
    }

    @Override
    public String toString() {
        return "Round (movebyPlayer1: " + moveByPlayer1 + ", moveByPlayer2: " + moveByPlayer2 + ")";
    }

}
