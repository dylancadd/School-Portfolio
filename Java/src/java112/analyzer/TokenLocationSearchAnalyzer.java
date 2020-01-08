package java112.analyzer;

// Import selected packages
import java.io.*;
import java.util.*;

/**
 * Gathers information from the FileAnalysis class and outputs the location
 * of each search token to a 'token_locations.txt' file
 * @author djcadd
 */
public class TokenLocationSearchAnalyzer implements TokenAnalyzer {

    // Create instance variables for a Map, Properties, and a currentLocation
    private Properties properties;
    private Map<String, List<Integer>> foundLocations;
    private int currentTokenLocation;

    /**
     * Whenever this analyzer is instantiated, instantiate a TreeSet and a
     * Properties object
     */
    public TokenLocationSearchAnalyzer() {

        // Create a TreeMap object
        foundLocations = new TreeMap<String, List<Integer>>();

        // Create a Properties object
        properties = new Properties();

    }

    /**
     * Whenever this analyzer is instantiated, assign the properties object
     * and load the search tokens from the properties
     * @param properties Assigns the properties object to this properties variable
     */
    public TokenLocationSearchAnalyzer(Properties properties) {

        // Assign properties to this objects properties
        this();
        this.properties = properties;
        this.loadSearchTokens();
    }

    /**
     * Returns the foundLocations key value pairs
     * @return Returns the key value pairs of foundLocations
     */
    public Map<String, List<Integer>> getFoundLocations() {
        return foundLocations;
    }

    /*
     * Loads the search tokens using the classpath and then calls
     * the readSearchTokens method to take care of them
     */
    public void loadSearchTokens() {
        String loadFile = properties.getProperty("classpath.search.tokens");

        try (
            InputStream inputStream = this.getClass().getResourceAsStream(loadFile);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader searchTokensReader = new BufferedReader(inputStreamReader)
        ) {

            readSearchTokens(searchTokensReader);

        } catch (IOException inputOutputException) {
            System.out.println("There was a problem reading the file");
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("There was a problem");
            exception.printStackTrace();
        }
    }

    /**
     * Reads through the search-tokens.txt and adds each word to the map
     * @param  searchTokens Gives us access to the search-token.txt via the
     *                      properties file
     * @throws IOException  Throws exception if need be
     */
    public void readSearchTokens(BufferedReader searchTokens) throws IOException {

        while (searchTokens.ready()) {
            String line = searchTokens.readLine();
            if (line.trim().length() > 0) {
                List<Integer> list = new ArrayList<Integer>();
                foundLocations.put(line, list);
            }
        }
    }

    /**
     * Checks to see if the Map contains the search word, and if so, add the
     * currentTokenLocation of the search word to the map
     * @param token Passes the token from the processTokenArray() in the FileAnalysis class
     */
    public void processToken(String token) {
        currentTokenLocation++;

        if(foundLocations.containsKey(token)) {
            foundLocations.get(token).add(currentTokenLocation);
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
                    new FileWriter(properties.getProperty("output.directory") + properties.getProperty("output.file.token.search.locations"))))
        ) {

            List<Integer> numbers = new ArrayList<Integer>();

            for (Map.Entry<String, List<Integer>> entry : getFoundLocations().entrySet()) {
                final int MAX_LIMIT = 75;
                int counter = 0;
                outputWriter.print(entry.getKey() + " =\n[");
                counter += entry.getKey().length();

                // Assigns all the values to the new array
                numbers = entry.getValue();

                // If any of the values in the map are empty, it prints the end
                // bracket
                if(entry.getValue().isEmpty()) {
                    outputWriter.print("]");
                }

                for (Integer number : numbers) {
                    if(numbers.indexOf(number) > (numbers.size() - 2)) {
                        counter += Integer.toString(number).length() + 1;

                        if (counter > MAX_LIMIT) {
                            outputWriter.println(number + "]");
                            counter = Integer.toString(number).length() + 1;
                        } else {
                            outputWriter.print(number + "]");
                        }
                    } else {
                        counter += Integer.toString(number).length() + 2;

                        if (counter > MAX_LIMIT) {
                            outputWriter.println(number + ",");
                            counter = Integer.toString(number).length() + 2;
                        } else {
                            outputWriter.print(number + ", ");
                        }
                    }
                }
                outputWriter.println("\n");
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
