package java112.analyzer;

// Import selected packages
import java.io.*;
import java.util.*;

/**
 * Gathers information from the FileAnalysis class and outputs the distinct
 * token counts to a 'distinct_counts.txt' file
 * @author djcadd
 */
public class DistinctTokenCountsAnalyzer implements TokenAnalyzer {

    // Create instance variables for a Map and Properties
    private Properties properties;
    private Map<String, Integer> distinctTokenCounts;

    /**
     * Whenever this analyzer is instantiated, instantiate a TreeSet and a
     * Properties object
     */
    public DistinctTokenCountsAnalyzer() {

        // Create a TreeMap object
        distinctTokenCounts = new TreeMap<String, Integer>();

        // Create a Properties object
        properties = new Properties();
    }

    /**
     * Whenever this analyzer is instantiated, assign the properties object
     * @param properties Assigns the properties object to this properties variable
     */
    public DistinctTokenCountsAnalyzer(Properties properties) {

        // Assign properties to this objects properties
        this();
        this.properties = properties;
    }

    /**
     * Returns the distinctTokenCounts value
     * @return Returns the total number of distinctTokenCounts
     */
    public Map<String, Integer> getDistinctTokenCounts() {
        return distinctTokenCounts;
    }

    /**
     * Checks to see if the Map contains the token, and if so, add to counter
     * @param token Passes the token from the processTokenArray() in the FileAnalysis class
     */
    public void processToken(String token) {

        // Checks to see whether or not to add a counter to the selected token
        if (distinctTokenCounts.containsKey(token)) {
            distinctTokenCounts.put(token, distinctTokenCounts.get(token) + 1);
        } else {
            distinctTokenCounts.put(token, 1);
        }
    }

    /**
     * Creates a file to output the results of the TreeMap
     * @param inputFilePath  Tells us which file is being processed by the Analyzer
     */
    public void generateOutputFile(String inputFilePath) {

        try (
            // Creates a PrintWriter to write to the designated file
            PrintWriter outputWriter = new PrintWriter(new BufferedWriter(
                    new FileWriter(properties.getProperty("output.directory") + properties.getProperty("output.file.distinct.counts"))))
        ) {
            // Loop through the TreeMap and outputs values on a separate line
            for (Map.Entry<String, Integer> entry : getDistinctTokenCounts().entrySet()) {
                outputWriter.println(entry.getKey() + "\t" + entry.getValue());
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
