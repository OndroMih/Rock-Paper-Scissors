package unittests;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import rockpaperscissors.PlayersMove;
import rockpaperscissors.RoundResult;
import static org.assertj.core.api.Assertions.*;
import rockpaperscissors.Round;

/**
 *
 * @author omihalyi
 */
public class RoundTest {
    
    public static class TestCondition {
        PlayersMove player1;
        PlayersMove player2;
        RoundResult expectedResult;
    }
    
    @ParameterizedTest
    @MethodSource("allRoundCombinationsWithResults")
    public void verifyRound(TestCondition condition) {
        Round round = new Round(condition.player1, condition.player2);
        assertThat(condition.expectedResult).as("Expected result of the %s", round)
                .isEqualTo(round.getResult());
    }
    
    public static Stream<TestCondition> allRoundCombinationsWithResults() {
        return Stream.of(
           condition(PlayersMove.PAPER, PlayersMove.PAPER, RoundResult.DRAW),
           condition(PlayersMove.PAPER, PlayersMove.ROCK, RoundResult.PLAYER_1_WINS),
           condition(PlayersMove.PAPER, PlayersMove.SCISSORS, RoundResult.PLAYER_2_WINS),
           condition(PlayersMove.ROCK, PlayersMove.ROCK, RoundResult.DRAW),
           condition(PlayersMove.ROCK, PlayersMove.PAPER, RoundResult.PLAYER_2_WINS),
           condition(PlayersMove.ROCK, PlayersMove.SCISSORS, RoundResult.PLAYER_1_WINS),
           condition(PlayersMove.SCISSORS, PlayersMove.SCISSORS, RoundResult.DRAW),
           condition(PlayersMove.SCISSORS, PlayersMove.ROCK, RoundResult.PLAYER_2_WINS),
           condition(PlayersMove.SCISSORS, PlayersMove.PAPER, RoundResult.PLAYER_1_WINS)
        );
    }
    
    private static TestCondition condition(PlayersMove player1, PlayersMove player2, RoundResult expectedResult) {
        TestCondition condition = new TestCondition();
        condition.player1 = player1;
        condition.player2 = player2;
        condition.expectedResult = expectedResult;
        return condition;
    }
}
