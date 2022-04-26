package rockpaperscissors;

/**
 *
 * @author omihalyi
 */
public class PlayRoundButton {

    private Game game;

    public PlayRoundButton(Game game) {
        this.game = game;
    }
    
    public void press() {
        game.playRound();
    }

}
