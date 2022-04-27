package rockpaperscissors;

import jakarta.validation.constraints.NotNull;

/**
 *
 * @author omihalyi
 */
public enum PlayersMove {
    ROCK,
    PAPER,
    SCISSORS;

    /**
     * Returns whether this value (represents Player 1) wins over otherMove (represents Player 2).
     * @param otherMove Move of the Player 2
     * @return PLAYER_1_WINS if this wins, PLAYER_2_WINS if this loses, DRAW otherwise
     */
    public RoundResult compareAgainst(@NotNull PlayersMove otherMove) {
        if (this.equals(otherMove)) {
            return RoundResult.DRAW;
        } else if (
                (this.equals(PAPER) && otherMove.equals(ROCK))
                || 
                (this.equals(SCISSORS) && otherMove.equals(PAPER))
                || 
                (this.equals(ROCK) && otherMove.equals(SCISSORS)) ) {
            return RoundResult.PLAYER_1_WINS;
        } else {
            return RoundResult.PLAYER_2_WINS;
        }
    }
}
