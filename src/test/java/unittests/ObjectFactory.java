package unittests;

import rockpaperscissors.Game;
import rockpaperscissors.PlayRoundButton;

/**
 * Creates objects for tests, hiding the way how the objects are created.
 * @author omihalyi
 */
public class ObjectFactory {
    
    private static final Game game;
    private static final PlayRoundButton button;
    
    static {
        game = new Game();
        button = new PlayRoundButton(game());
    }
    
    public static PlayRoundButton playRoundButton() {
        return button;
    }
    
    public static Game game() {
        return game;
    }
}
