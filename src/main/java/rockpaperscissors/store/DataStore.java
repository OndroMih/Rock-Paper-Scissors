package rockpaperscissors.store;

import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import rockpaperscissors.Round;

/**
 *
 * @author omihalyi
 */
@SessionScoped
public class DataStore implements Serializable {
    private List<Round> rounds = new ArrayList<>();
    
    public List<Round> getRounds() {
        return rounds;
    }
}
