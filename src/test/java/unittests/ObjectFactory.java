package unittests;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import rockpaperscissors.Game;
import rockpaperscissors.store.DataStore;

/**
 * Creates objects for tests, hiding the way how the objects are created.
 * @author omihalyi
 */
public class ObjectFactory {
    
    private final Game game;
    private final DataStore store;
    
    public ObjectFactory() {
        SeContainer cdiContainer = SeContainerInitializer.newInstance().initialize();
        store = new DataStore();
        game = new Game(store);
    }
    
    public Game game() {
        return game;
    }
}
