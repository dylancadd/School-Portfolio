package java112.analyzer;

// Import selected packages
import java.io.*;
import java.util.*;
import java112.utilities.*;

/**
 * The main application proccessing class.
 *
 * Checks which file was entered via the command line and calls different
 * analyzers to output different analyzes and a summary report
 * @author djcadd
 */
public class FileAnalysis implements PropertiesLoader {

    // Create instance variables
    static final int MAX_ARGUMENTS = 2;
    private ArrayList<TokenAnalyzer> analyzers;

    /**
     * Calls the checkCommandLine() to start the Analyze application
     * @param arguments Grabs the command line arguments from the Driver class
     */
    public void analyze(String[] arguments) {

        // Test the arguments to ensure it equals MAX_ARGUMENTS
        if (arguments.length == MAX_ARGUMENTS) {

            // Loads all the properties with the 2nd argument from the command line
            Properties properties = loadProperties(arguments[1]);

            // Instantiates all of the analyzer classes
            createAnalyzers(properties);

            // Creates BufferedReader to read the selected file
            splitArray(arguments[0]);

            // Sends the argument to be outputted by the correct analyzers
            writeOutputFiles(arguments[0]);

        } else {
            // Prints an error
            errorMessage();
        }
    }

    /**
     * Prints out an error message for the command line arguments
     */
    public void errorMessage() {

        // Output error message to the terminal if arguments requirements
        // aren't met
        System.out.println("Please enter one argument on the command line, an input file name");
    }

    /**
     * Instantiates all of the analyzer classes
     * @param properties Sends the properties and sends them to corresponding
     * analyzer
     */
    public void createAnalyzers(Properties properties) {

        // Create new ArrayList to hold the analyzers
        analyzers = new ArrayList<TokenAnalyzer>();

        // Adds all the analyzers to an ArrayList
        analyzers.add(new FileSummaryAnalyzer(properties));
        analyzers.add(new DistinctTokensAnalyzer(properties));
        analyzers.add(new LargestTokensAnalyzer(properties));
        analyzers.add(new DistinctTokenCountsAnalyzer(properties));
        analyzers.add(new TokenLengthsAnalyzer(properties));
        analyzers.add(new TokenLocationSearchAnalyzer(properties));
    }

    /**
     * Creates the BufferedReader to read the selected file
     * @param arguments Passes the arguments from checkCommandLine()
     */
    public void splitArray(String arguments) {

        try (BufferedReader inputReader = new BufferedReader(new FileReader(arguments))) {
            // Creates varibles in order to read the file and add them to an array
            String inputLine = null;
            String[] tokenArray = null;

            // If the file is ready to be read, read each line and add to array
            while(inputReader.ready()) {
                inputLine = inputReader.readLine();
                tokenArray = inputLine.split("\\W");
                processTokenArray(tokenArray);
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

/**
 * Loops through each token and sends to method that calls the analyzer
 * @param tokenArray  Tells us which array to be looped through
 */
    public void processTokenArray(String[] tokenArray) {
        for (String token : tokenArray) {
            sendToAnalyzer(token);
        }
    }

    /**
     * Loops through the analyzers and sends to token to each analyzer
     * @param token Gives us the token from the arrayList
     */
    public void sendToAnalyzer(String token) {
        for (TokenAnalyzer analyzer : analyzers) {
            if (token.length() > 0) {
                analyzer.processToken(token);
            }
        }
    }

    /**
     * Sends the inputFilePath to the analyzer
     * @param inputFilePath Tells us which file is being analyzed
     */
    public void writeOutputFiles(String inputFilePath) {
        for (TokenAnalyzer analyzer : analyzers) {
            analyzer.generateOutputFile(inputFilePath);
        }
    }
}
