package java112.analyzer;

// Import selected packages
import java.io.*;
import java.util.*;

/**
 * Gathers information from the FileAnalysis class and outputs the distinct
 * token counts to a 'token_lengths.txt' file
 * @author djcadd
 */
public class TokenLengthsAnalyzer implements TokenAnalyzer {

    // Create instance variables for a Map and Properties
    private Properties properties;
    private Map<Integer, Integer> tokenLengths;

    /**
     * Whenever this analyzer is instantiated, instantiate a TreeSet and a
     * Properties object
     */
    public TokenLengthsAnalyzer() {

        // Create a TreeMap object
        tokenLengths = new TreeMap<Integer, Integer>();

        // Create a Properties object
        properties = new Properties();
    }

    /**
     * Whenever this analyzer is instantiated, assign the properties object
     * @param properties Assigns the properties object to this properties variable
     */
    public TokenLengthsAnalyzer(Properties properties) {

        // Assign properties to this objects properties
        this();
        this.properties = properties;
    }

    /**
     * Returns the tokenLengths value
     * @return Returns the key value pair of tokenLengths
     */
    public Map<Integer, Integer> getTokenLengths() {
        return tokenLengths;
    }

    /**
     * Checks to see if the Map contains the token, and if so, add to the map
     * @param token Passes the token from the processTokenArray() in the FileAnalysis class
     */
    public void processToken(String token) {

        if (tokenLengths.containsKey(token.length())) {
            tokenLengths.put(token.length(), tokenLengths.get(token.length()) + 1);
        } else {
            tokenLengths.put(token.length(), 1);
        }

    }

    /**
     * Assigns the value to the currentValue
     * @param  value Retrieves the value of the certain item in the map
     * @return       Returns the value of currentValue
     */
    public int getCurrentValue(int value) {
        int currentValue = value;

        return currentValue;
    }

    /**
     * Creates a file to output the results of the TreeMap and displays a
     * histogram
     * @param inputFilePath  Tells us which file is being processed by the Analyzer
     */
    public void generateOutputFile(String inputFilePath) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        Integer max = Collections.max(tokenLengths.values());
        int round;
        int current;

        try (
            // Creates a PrintWriter to write to the designated file
            PrintWriter outputWriter = new PrintWriter(new BufferedWriter(
                    new FileWriter(properties.getProperty("output.directory") + properties.getProperty("output.file.token.lengths"))))
        ) {
            // Loop through the TreeMap and outputs values on a separate line
            for (Map.Entry<Integer, Integer> entry : getTokenLengths().entrySet()) {
                outputWriter.println(entry.getKey() + "\t" + entry.getValue());

            }

            outputWriter.println();

            // Loop through the TreeMap and draws a histogram depending on the
            // size of the words
            for (Map.Entry<Integer, Integer> item : getTokenLengths().entrySet()) {

                double value = item.getValue();
                double valueX = value / max * 80;

                round = (int) Math.ceil(valueX);
                current = getCurrentValue(round);

                outputWriter.print(item.getKey() + "\t");


                for(int i = 0; i < current; i++) {
                    outputWriter.print("*");
                }
                outputWriter.println();
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
