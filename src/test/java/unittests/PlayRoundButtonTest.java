package unittests;

import rockpaperscissors.Game;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import rockpaperscissors.PlayRoundButton;

/**
 *
 * @author omihalyi
 */
public class PlayRoundButtonTest {

    PlayRoundButton button;
    Game game;

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        button = ObjectFactory.playRoundButton();
        game = ObjectFactory.game();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void playButtonRunsOneRound() {
        button.press();

        int numberOfRounds = game.numberOfRoundsForCurrentUser();
        assertThat(numberOfRounds).isEqualTo(1);
        
        int roundsPlayed = game.roundsPlayed();
        assertThat(roundsPlayed).isEqualTo(1);

    }
}
