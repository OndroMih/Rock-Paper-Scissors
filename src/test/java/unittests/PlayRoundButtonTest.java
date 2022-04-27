package unittests;

import rockpaperscissors.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import rockpaperscissors.PlayRoundButton;
import rockpaperscissors.PlayersMove;
import rockpaperscissors.Round;
import rockpaperscissors.RoundResult;

/**
 *
 * @author omihalyi
 */
public class PlayRoundButtonTest {

    PlayRoundButton button;
    Game game;

    @BeforeEach
    public void setUp() {
        button = ObjectFactory.playRoundButton();
        game = ObjectFactory.game();
    }

    @Test
    public void playButtonRunsOneRound() {
        button.press();

        int numberOfRounds = game.numberOfRoundsForCurrentUser();
        assertThat(numberOfRounds).as("Number of rounds").isEqualTo(1);

        int roundsPlayed = game.roundsPlayed();
        assertThat(roundsPlayed).as("Rounds played").isEqualTo(1);

        game.getRounds().forEach(round -> {
            verifyRound(round);
        });

    }

    private RoundResult computeResultOfRound(PlayersMove movePlayer1, PlayersMove movePlayer2) {
        if (movePlayer1.equals(movePlayer2)) {
            return RoundResult.DRAW;
        } else if (movePlayer1.equals(PlayersMove.PAPER)) {
            switch (movePlayer2) {
                case ROCK:
                    return RoundResult.PLAYER_1_WINS;
                case SCISSORS:
                    return RoundResult.PLAYER_2_WINS;
                default:
                    caseNotCovered();
            }
        } else if (movePlayer1.equals(PlayersMove.ROCK)) {
            switch (movePlayer2) {
                case SCISSORS:
                    return RoundResult.PLAYER_1_WINS;
                case PAPER:
                    return RoundResult.PLAYER_2_WINS;
                default:
                    caseNotCovered();
            }
        } else if (movePlayer1.equals(PlayersMove.SCISSORS)) {
            switch (movePlayer2) {
                case PAPER:
                    return RoundResult.PLAYER_1_WINS;
                case ROCK:
                    return RoundResult.PLAYER_2_WINS;
                default:
                    caseNotCovered();
            }
        }
        caseNotCovered();
        return null;
    }

    private void verifyRound(Round round) {

        PlayersMove movePlayer1 = round.getMoveByPlayer1();
        PlayersMove movePlayer2 = round.getMoveByPlayer2();
        RoundResult expectedResult;

        assertThat(movePlayer1).as("Move by player 1").isNotNull();
        assertThat(movePlayer2).as("Move by player 2").isEqualTo(PlayersMove.ROCK);

        expectedResult = computeResultOfRound(movePlayer1, movePlayer2);

        assertThat(round.getResult())
                .as("The result of this round (Move of player 1: %s; Move of player 2: %s)", movePlayer1, movePlayer2)
                .isEqualTo(expectedResult);
                
    }

    private void caseNotCovered() {
        throw new CaseNotCoveredByTest("This case isn't covered by tests");
    }

}
