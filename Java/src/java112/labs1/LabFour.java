package java112.labs1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;



public class LabFour {

    public static void main(String[] args) throws IOException {

        // Creates an object reference to LabFour to be able to call run()
        LabFour lab = new LabFour();

        // Checks to see if an argument was passed
        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line");
        } else {
            lab.run(args[0]);
        }
    }

    public void run(String input) throws IOException {

        FileReader reader = new FileReader(input);

        BufferedReader in = new BufferedReader(reader);
        BufferedReader inputReader = null;

        try {
            inputReader = new BufferedReader(new FileReader(input));
            String line = null;

            while(inputReader.ready()) {
                line = inputReader.readLine();
                System.out.println(line);
            }
        } catch(FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } finally {
            try {
                if (inputReader != null) {
                    inputReader.close();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
