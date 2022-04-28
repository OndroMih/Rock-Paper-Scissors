package unittests.mocks;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import rockpaperscissors.store.DataStore;

/**
 *
 * @author omihalyi
 */
@ApplicationScoped
public class MockFactory {
    @Produces
    @Dependent
    public DataStore getDataStore() {
        return new DataStore();
    }
}
