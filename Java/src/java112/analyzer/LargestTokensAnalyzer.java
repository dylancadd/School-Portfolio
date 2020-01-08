package java112.analyzer;

// Import selected packages
import java.io.*;
import java.util.*;
import java112.utilities.*;

/**
 * Gathers information from the FileAnalysis class and outputs the largest
 * tokens to a 'largest_words.txt' file
 * @author djcadd
 */
public class LargestTokensAnalyzer implements TokenAnalyzer {

    // Create instance variables
    private Properties properties;
    private Set<String> largestTokens;
    private int minimumTokenLength;

    /**
     * Whenever this analyzer is instantiated, create TreeSet and Properties objects
     */
    public LargestTokensAnalyzer() {

        // Create TreeSet objects
        largestTokens = new TreeSet<String>();

        // Create Properties object
        properties = new Properties();

    }


    /**
     * Whenever this analyzer is instantiated, assign the properties object
     * @param properties Assigns the properties object to this properties variable
     */
    public LargestTokensAnalyzer(Properties properties) {
        this();
        this.properties = properties;

        // Assign minimumTokenLength to the correct property
        minimumTokenLength = Integer.parseInt(properties.getProperty("largest.words.minimum.length"));
    }

    /**
     * Returns the largestTokens value
     * @return Returns the largest tokens from the inputted file
     */
    public Set<String> getLargestTokens() {
        return largestTokens;
    }

    /**
     * Checks to see if the token is more than minimumTokenLength and then adds it to the TreeSet
     * @param token Passes the token from the proccessTokenArray() in the FileAnalysis class
     */
    public void processToken(String token) {

        // Add to TreeSet if the length is greater than the minimumTokenLength
        if(token.length() >= minimumTokenLength) {
            largestTokens.add(token);
        }
    }

    /**
     * Creates a file to output the results of the TreeSet
     * @param inputFilePath  Tells us which file is being processed by the Analyzer
     */
    public void generateOutputFile(String inputFilePath) {

        try (
            // Creates a PrintWriter to write to the designated file
            PrintWriter outputWriter = new PrintWriter(new BufferedWriter(
                    new FileWriter(properties.getProperty("output.directory") + properties.getProperty("output.file.largest.words"))))
        ) {
            // Loop through the TreeSet and outputs the word
            for (String token : getLargestTokens()) {
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
