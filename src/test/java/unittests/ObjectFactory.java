package unittests;

import jakarta.enterprise.event.Event;
import jakarta.enterprise.event.NotificationOptions;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.enterprise.util.TypeLiteral;
import java.lang.annotation.Annotation;
import java.util.concurrent.CompletionStage;
import rockpaperscissors.Game;
import rockpaperscissors.Round;
import rockpaperscissors.monitoring.Monitoring;
import rockpaperscissors.store.DataStore;

/**
 * Creates objects for tests, hiding the way how the objects are created.
 * @author omihalyi
 */
public class ObjectFactory {
    
    private final Game game;
    private final Game anotherGame;
    private final Monitoring monitoring;
    
    public ObjectFactory() {
        this(false);
    }
    
    public ObjectFactory(boolean cdiEnabled) {
        if (cdiEnabled) {
            SeContainer cdiContainer = SeContainerInitializer.newInstance()
                    .addPackages(Game.class)
                    .addPackages(Monitoring.class)
                    .initialize();
            game = cdiContainer.select(Game.class).get();
            anotherGame = cdiContainer.select(Game.class).get();
            monitoring = cdiContainer.select(Monitoring.class).get();
        } else {
            game = new Game(new DataStore(), new NoopEvent<Round>());
            anotherGame = new Game(new DataStore(), new NoopEvent<Round>());
            monitoring = new Monitoring();
        }
    }
    
    public Game game() {
        return game;
    }

    public Monitoring monitoring() {
        return monitoring;
    }

    public Game gameInAnotherSession() {
        return anotherGame;
    }

}
