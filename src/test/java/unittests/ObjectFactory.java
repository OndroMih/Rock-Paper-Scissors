package unittests;

import rockpaperscissors.Game;
import rockpaperscissors.monitoring.Monitoring;
import rockpaperscissors.store.DataStore;

/**
 * Creates objects for tests, hiding the way how the objects are created.
 * @author omihalyi
 */
public class ObjectFactory {
    
    private final Game game;
    private final DataStore store;
    private final Monitoring monitoring;
    
    public ObjectFactory() {
        store = new DataStore();
        game = new Game(store);
        monitoring = new Monitoring();
    }
    
    public Game game() {
        return game;
    }

    public Monitoring monitoring() {
        return monitoring;
    }

    public Game gameInAnotherSession() {
        return game;
    }
}
