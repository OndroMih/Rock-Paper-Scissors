package rockpaperscissors.monitoring;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Named;
import java.util.concurrent.atomic.AtomicInteger;
import rockpaperscissors.Round;

/**
 *
 * @author omihalyi
 */
@ApplicationScoped
@Named
public class Monitoring {
    
    private AtomicInteger totalRounds = new AtomicInteger(0);
    private AtomicInteger totalWinsOfFirstPlayers = new AtomicInteger(0);
    private AtomicInteger totalWinsOfSecondPlayers = new AtomicInteger(0);
    private AtomicInteger totalDraws = new AtomicInteger(0);
    
    public int getTotalRounds() {
        return totalRounds.get();
    }
    
    public int getTotalWinsOfFirstPlayers() {
        return totalWinsOfFirstPlayers.get();
    }

    public int getTotalWinsOfSecondPlayers() {
        return totalWinsOfSecondPlayers.get();
    }

    public int getTotalDraws() {
        return totalDraws.get();
    }
    
    public void handleRoundEvent(@Observes Round event) {
        totalRounds.incrementAndGet();
        switch (event.getResult()) {
            case PLAYER_1_WINS:
                totalWinsOfFirstPlayers.incrementAndGet();
                break;
            case PLAYER_2_WINS:
                totalWinsOfSecondPlayers.incrementAndGet();
                break;
            case DRAW:
                totalDraws.incrementAndGet();
                break;
        }
    }
}
