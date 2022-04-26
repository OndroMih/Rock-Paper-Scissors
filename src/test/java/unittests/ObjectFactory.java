package unittests;

import rockpaperscissors.Game;
import rockpaperscissors.PlayRoundButton;

/**
 * Creates objects for tests, hiding the way how the objects are created.
 * @author omihalyi
 */
public class ObjectFactory {
    
    public static PlayRoundButton playRoundButton() {
        return new PlayRoundButton();
    }
    
    public static Game game() {
        return new Game();
    }
}
