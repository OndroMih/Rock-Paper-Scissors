package rockpaperscissors;

import java.util.Optional;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import java.util.stream.Stream;
import rockpaperscissors.store.DataStore;

/**
 *
 * @author omihalyi
 */
@Dependent
public class Game {

    DataStore store;
            
    private Player player1 = new RandomPlayer();
    private Player player2 = new AlwaysRockPlayer();
    
    private Event<Round> roundFinishedEvent;

    @Inject
    public Game(DataStore store, Event<Round> roundFinishedEvent) {
        this.store = store;
        this.roundFinishedEvent = roundFinishedEvent;
    }
    
    public int numberOfRoundsForCurrentUser() {
        return store.getRounds().size();
    }

    public int roundsPlayed() {
        return store.getRounds().size();
    }
    
    public void playRound() {
        Round round = new Round(player1.move(), player2.move());
        addRound(round);
    }

    private void addRound(Round round) {
        store.getRounds().add(round);
        roundFinishedEvent.fire(round);
    }

    public Stream<Round> getRounds() {
        return store.getRounds().stream();
    }

    public void restart() {
        store.getRounds().clear();
    }

    public Optional<RoundResult> getLastResult() {
        if (store.getRounds().isEmpty()) {
            return Optional.empty();
        } else {
            Round lastRount = store.getRounds().get(store.getRounds().size()-1);
            return Optional.of(lastRount.getResult());
        }
    }

}
