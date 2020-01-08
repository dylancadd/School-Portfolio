package java112.analyzer;

// Import selected packages
import java.util.*;

/**
 * Specifies two methods without implementing them until called upon
 * @author djcadd
 */
public interface TokenAnalyzer {

    /**
     * Interface method to grab the token
     * @param token Grabs the token from another method through an interface
     */
    void processToken(String token);

    /**
     * Interface method to grab the inputfilePath and outputFilePath
     * @param inputFilePath  Tells us which file is being inputted
     */
    void generateOutputFile(String inputFilePath);
}
