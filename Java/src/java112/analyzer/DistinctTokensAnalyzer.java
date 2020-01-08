package java112.analyzer;

// Import selected packages
import java.io.*;
import java.util.*;

/**
 * Gathers information from the FileAnalysis class and outputs the distinct
 * tokens to a 'distinct_tokens.txt' file making sure there isn't any duplicates
 * @author djcadd
 */
public class DistinctTokensAnalyzer implements TokenAnalyzer {

    // Create instance variables
    private Set<String> distinctTokens;
    private Properties properties;

    /**
     * Whenever this analyzer is instantiated, instantiate a TreeSet
     */
    public DistinctTokensAnalyzer() {

        // Create a TreeMap object
        distinctTokens = new TreeSet<>();

        // Create a Properties object
        properties = new Properties();
    }

    /**
     * Whenever this analyzer is instantiated, assign the properties object
     * @param properties Assigns the properties object to this properties variable
     */
    public DistinctTokensAnalyzer(Properties properties) {

        // Assign properties to this objects properties
        this();
        this.properties = properties;
    }

    /**
     * Returns the distinctTokens value
     * @return Returns the total number of distinct tokens in the TreeSet
     */
    public Set<String> getDistinctTokens() {
        return distinctTokens;
    }

    /**
     * Checks to see if the token is empty and then adds it to the TreeSet
     * @param token Passes the token from the getTokens() in the FileAnalysis class
     */
    public void processToken(String token) {

        // Add token to TreeSet
        distinctTokens.add(token);
    }

    /**
     * Creates a file to output the results of the TreeSet
     * @param inputFilePath  Tells us which file is being processed by the Analyzer
     */
    public void generateOutputFile(String inputFilePath) {

        try (
            // Creates a PrintWriter to write to the designated file
            PrintWriter outputWriter = new PrintWriter(new BufferedWriter(
                    new FileWriter(properties.getProperty("output.directory") + properties.getProperty("output.file.distinct"))))
        ) {
            // Loop through the TreeSet, output the item and add to the token count
            for (String token : getDistinctTokens()){
                outputWriter.println(token);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File was not found.");
            fileNotFoundException.printStackTrace();
        } catch (IOException iOException) {
            System.out.println("File could not be read.");
            iOException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("There was a problem.");
            exception.printStackTrace();
        }
    }
}
