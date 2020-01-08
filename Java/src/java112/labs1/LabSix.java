package java112.labs1;
import java.io.*;

public class LabSix {

    public static void main(String[] args) {

        // Checks to see if 2 arguments were passed
        if (args.length != 2) {
            System.out.println("Please enter two arguments on the command line, an input file name and an output file name");
        } else {
            // Creates an object reference to LabSix to be able to call run()
            // and pass the 2 arguments
            LabSix lab = new LabSix();
            lab.run(args[0], args[1]);
        }
    }

    public void run(String input, String output) {

        // Creates new Reader and Writer
        try (
            BufferedReader inputReader = new BufferedReader(new FileReader(input));
            PrintWriter outputWriter = new PrintWriter(new BufferedWriter(
                    new FileWriter(output)))
        ) {

            // If file is ready to be read, read each line and output to another file
            while (inputReader.ready()) {
                outputWriter.println(inputReader.readLine());
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
