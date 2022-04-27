package rockpaperscissors;

import java.util.Optional;
import java.util.stream.Stream;
import rockpaperscissors.store.DataStore;

/**
 *
 * @author omihalyi
 */
public class Game {

    DataStore store;
            
    private Player player1 = new RandomPlayer();
    private Player player2 = new AlwaysRockPlayer();

    public Game(DataStore store) {
        this.store = store;
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
        fireRoundEvents(round);
    }

    private void addRound(Round round) {
        store.getRounds().add(round);
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

    private void fireRoundEvents(Round round) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
