package unittests;

/**
 * An exception to use if the case isn't covered by the test scenario. 
 * This is mostly if the case isn't possible now but might become possible if API changes.
 * If this exception is thrown by a test, the test must likely be fixed.
 * 
 * @author omihalyi
 */
public class CaseNotCoveredByTest extends RuntimeException {

    public CaseNotCoveredByTest(String message) {
    }
    
}
