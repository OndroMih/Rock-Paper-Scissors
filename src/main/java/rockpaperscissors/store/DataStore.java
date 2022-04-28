package rockpaperscissors.store;

import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import rockpaperscissors.Round;

/**
 * The default store for the game. Session scoped - each user/session has its own storage.
 * @author omihalyi
 */
@SessionScoped
public class DataStore implements Serializable {
    private List<Round> rounds = new ArrayList<>();
    
    public List<Round> getRounds() {
        return rounds;
    }
}
