package java112.analyzer;

// Import selected packages
import java.io.*;
import java.util.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.net.URI;

/**
 * Gathers information from the FileAnalysis class about the selected file
 * and outputs the summary information to a 'summary.txt' located in the
 * output directory
 * @author djcadd
 */
public class FileSummaryAnalyzer implements TokenAnalyzer {

    // Create instance variables
    private int totalTokensCount;
    private Properties properties;

    /**
     * Whenever this analyzer is instantiated, set total count to 0 and create
     * Properties object
     */
    public FileSummaryAnalyzer() {

        // Assigns totalTokensCount to 0
        totalTokensCount = 0;

        // Creates a Property object
        properties = new Properties();
    }

    /**
     * Whenever this analyzer is instantiated, assign the properties object
     * @param properties Assigns the properties object to this properties variable
     */
    public FileSummaryAnalyzer(Properties properties) {

        // Assign properties to this objects properties
        this();
        this.properties = properties;
    }

    /**
     * Returns the total count of tokens that were in the file
     * @return The total count of tokens
     */
    public int getTotalTokensCount() {
        return totalTokensCount;
    }

    /**
     * Processes the token and verifies that it is not empty, then adds to
     * the total count
     * @param token Tells us which token is being tested and added to the count
     */
    public void processToken(String token) {

        // Adds token to the totalTokensCount
        totalTokensCount++;
    }

    /**
     * Generates all of the information we need to complete a summary of the
     * analyzed file and writes it via a PrintWriter
     * @param inputFilePath  Tells us which file is being analyzed
     */
    public void generateOutputFile(String inputFilePath) {

        try (
            PrintWriter outputWriter = new PrintWriter(new BufferedWriter(
                    new FileWriter(properties.getProperty("output.directory") + properties.getProperty("output.file.summary"))))
        ) {
            // Create variables to gather information about the file
            File file;
            URI uri;
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy 'at' HH:mm:ss");
            SimpleDateFormat formatter= new SimpleDateFormat("MM/dd/yyyy 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());

            // Selects the correct file from the command line
            file = new File(inputFilePath);
            uri = file.toURI();

            // Writes the summary report to 'summary.txt'
            outputWriter.println("Application: " + properties.getProperty("application.name"));
            outputWriter.println("Author: " + properties.getProperty("author"));
            outputWriter.println("Author Email: " + properties.getProperty("author.email.address"));
            outputWriter.println("File: " + file.getAbsolutePath());
            outputWriter.println("Date of Analysis: " + formatter.format(date));
            outputWriter.println("Last Modified: " + sdf.format(file.lastModified()));
            outputWriter.println("File Size: " + file.length() + " bytes");
            outputWriter.println("File URI: " + uri);
            outputWriter.println("Total Tokens: " + getTotalTokensCount());

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
