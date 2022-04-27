package unittests;

import rockpaperscissors.Game;

/**
 * Creates objects for tests, hiding the way how the objects are created.
 * @author omihalyi
 */
public class ObjectFactory {
    
    private final Game game;
    
    public ObjectFactory() {
        game = new Game();
    }
    
    public Game game() {
        return game;
    }
}
