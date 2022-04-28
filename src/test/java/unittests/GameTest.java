package unittests;

import java.util.Random;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import rockpaperscissors.Game;
import rockpaperscissors.PlayersMove;
import rockpaperscissors.Round;
import rockpaperscissors.RoundResult;

/**
 *
 * @author omihalyi
 */
public class GameTest {

    Game game;

    @BeforeEach
    public void setUp() {
        ObjectFactory factory = new ObjectFactory(true);
        game = factory.game();
    }
    
    @Test
    public void verifyInitialGameState() {
        assertThat( game.numberOfRoundsForCurrentUser() ).as("Number of rounds of current user").isEqualTo(0);
        assertThat( game.roundsPlayed() ).as("Rounds played").isEqualTo(0);
        assertThat( game.getRounds().count() ).as("Number of round records").isEqualTo(0);
    }

    @Test
    public void gameRunsOneRound() {
        game.playRound();

        int numberOfRounds = game.numberOfRoundsForCurrentUser();
        assertThat(numberOfRounds).as("Number of rounds").isEqualTo(1);

        int roundsPlayed = game.roundsPlayed();
        assertThat(roundsPlayed).as("Rounds played").isEqualTo(1);
        
        long roundsRecorded = game.getRounds().count();
        assertThat(roundsRecorded).as("Number of round records").isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9,10})
    public void statisticsAfterMultipleRounds(int numberOfRoundsToPlay) {
        runGameMultipleTimes(numberOfRoundsToPlay);

        int numberOfRounds = game.numberOfRoundsForCurrentUser();
        assertThat(numberOfRounds).as("Number of rounds").isEqualTo(numberOfRoundsToPlay);

        int roundsPlayed = game.roundsPlayed();
        assertThat(roundsPlayed).as("Rounds played").isEqualTo(numberOfRoundsToPlay);

        game.getRounds().forEach(round -> {
            verifyRound(round);
        });

    }

    private void runGameMultipleTimes(int numberOfRoundsToPlay) {
        for (int i = 0; i < numberOfRoundsToPlay; i++) {
            game.playRound();
        }
    }
    
    @Test
    public void gameRestarts() {
        runGameMultipleTimes(new Random().nextInt(10) + 1);
        game.restart();
        verifyInitialGameState();
    }
    
    @Test
    public void gameRunsOneRoundAfterRestart() {
        runGameMultipleTimes(new Random().nextInt(10) + 1);
        game.restart();
        gameRunsOneRound();
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
