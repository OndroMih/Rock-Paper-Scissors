package unittests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rockpaperscissors.Game;
import rockpaperscissors.monitoring.Monitoring;
import static org.assertj.core.api.Assertions.*;
import rockpaperscissors.RoundResult;

/**
 *
 * @author omihalyi
 */
public class MonitoringTest {

    Game game;
    Game game2;
    Monitoring monitoring;

    @BeforeEach
    public void setUp() {
        ObjectFactory factory = new ObjectFactory();
        game = factory.game();
        game = factory.gameInAnotherSession();
        monitoring = factory.monitoring();
    }

    private static class Metrics {

        int totalRounds = 0;
        int totalWinsFirstPlayers = 0;
        int totalWinsSecondPlayers = 0;
        int totalDraws = 0;
    }

    @Test
    public void testMonitoringForASingleSession() {

        Metrics m = new Metrics();

        verifyTestMetricsAgainstMonitoring(m);

        playGameNumberOfTimesAndVerifyAgainstMetrics(game, 10, m);

        game.restart();

        verifyTestMetricsAgainstMonitoring(m);

        playGameNumberOfTimesAndVerifyAgainstMetrics(game, 5, m);
    }

    @Test
    public void testMonitoringFor2Sessions() {

        Metrics m = new Metrics();

        verifyTestMetricsAgainstMonitoring(m);

        playGameNumberOfTimesAndVerifyAgainstMetrics(game, 3, m);
        playGameNumberOfTimesAndVerifyAgainstMetrics(game2, 5, m);

        game.restart();
        verifyTestMetricsAgainstMonitoring(m);

        playGameNumberOfTimesAndVerifyAgainstMetrics(game2, 3, m);
        playGameNumberOfTimesAndVerifyAgainstMetrics(game, 6, m);
        
        game2.restart();
        verifyTestMetricsAgainstMonitoring(m);
        
    }

    private void playGameNumberOfTimesAndVerifyAgainstMetrics(Game game, int numberOfTimes, Metrics m) {
        for (int i = 0; i < numberOfTimes; i++) {
            game.playRound();
            updateTestMetricsWithLastGameResult(game, m);
            verifyTestMetricsAgainstMonitoring(m);
        }
    }

    private void updateTestMetricsWithLastGameResult(Game game, Metrics m) {
        RoundResult result = game.getLastResult();
        switch (result) {
            case DRAW:
                m.totalDraws++;
                break;
            case PLAYER_1_WINS:
                m.totalWinsFirstPlayers++;
                break;
            case PLAYER_2_WINS:
                m.totalWinsSecondPlayers++;
                break;
        }
        m.totalRounds++;
    }

    private void verifyTestMetricsAgainstMonitoring(Metrics m) {
        assertThat(monitoring.getTotalRounds()).as("Total rounds").isEqualTo(m.totalRounds);
        assertThat(monitoring.getTotalWinsOfFirstPlayers())
                .as("Total wins for first players").isEqualTo(m.totalWinsFirstPlayers);
        assertThat(monitoring.getTotalWinsOfSecondPlayers())
                .as("Total wins for second players").isEqualTo(m.totalWinsSecondPlayers);
        assertThat(monitoring.getTotalDraws()).as("Total draws").isEqualTo(m.totalDraws);
    }
}
