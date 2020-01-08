package java112.labs1;
import java.util.*;
import java.io.*;

public class LabEight {

    private Set<String> set;

    public static void main(String[] args) throws IOException {

        // Checks to see if 1 argument was passed
        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line, an output file name");
        } else {
            // Creates an object reference to LabEight to be able to call run()
            // and pass the argument
            LabEight lab = new LabEight();
            lab.run(args[0]);
        }


    }

    public void run(String argument) throws IOException {

        set = new TreeSet<>();

        set.add("one");
        set.add("one");
        set.add("five");
        set.add("two");
        set.add("four");
        set.add("two");
        set.add("three");
        set.add("three");
        set.add("four");
        set.add("three");

        writeListToOutputFile(argument);

    }

    public void writeListToOutputFile(String output) throws IOException {

        PrintWriter outputWriter = null;

        try {
            outputWriter = new PrintWriter(new BufferedWriter(new FileWriter(output)));
            for (String element : set){
            outputWriter.println(element);
        }
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
