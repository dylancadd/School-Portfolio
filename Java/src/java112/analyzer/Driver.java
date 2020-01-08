package java112.analyzer;

/**
 * Creates an instant variable to FileAnalysis and passes the arguments
 * @author djcadd
 */
public class Driver {

    /**
     * Takes the arguments from the command line and passes them to the
     * analyze method in the FileAnalysis class
     * @param args Grabs the arguments from the command line
     */
    public static void main(String[] args) {

        // Instantiates the fileAnalysis class
        FileAnalysis fileAnalysis = new FileAnalysis();

        // Passes the command line arguments to the FileAnalysis class
        fileAnalysis.analyze(args);
    }
}
