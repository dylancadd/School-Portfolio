package java112.labs1;

import java.io.*;
// import java.io.PrintWriter;
// import java.io.BufferedWriter;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.io.FileNotFoundException;

public class LabFive {

    public static void main(String[] args) throws IOException {

        // Creates an object reference to LabFive to be able to call run()
        LabFive lab = new LabFive();

        // Checks to see if 2 arguments were passed
        if (args.length != 2) {
            System.out.println("Please enter two arguments on the command line, a file name and a message");
        } else {
            lab.run(args[0], args[1]);
        }

    }

    public void run(String name, String message) throws IOException {

        PrintWriter outputWriter = null;

        try {
            outputWriter = new PrintWriter(new BufferedWriter(new FileWriter(name)));
            outputWriter.println(message);
        } catch (IOException iOException) {
            System.out.println("There was a problem writing the file");
            iOException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("There was a problem...");
            exception.printStackTrace();
        } finally {
            if (outputWriter != null) {
                outputWriter.close();
            }
        }
    }
}
