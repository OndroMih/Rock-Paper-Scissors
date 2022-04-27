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
    
    public ObjectFactory() {
        this(false);
    }
    
    public ObjectFactory(boolean cdiEnabled) {
        if (cdiEnabled) {
            SeContainer cdiContainer = SeContainerInitializer.newInstance()
                    .addPackages(Game.class)
                    .initialize();
            game = cdiContainer.select(Game.class).get();
        } else {
            game = new Game(new DataStore());
        }
    }
    
    public Game game() {
        return game;
    }
}
