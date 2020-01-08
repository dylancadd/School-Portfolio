package java112.labs1;
import java.util.*;
import java.io.*;

public class LabSeven {

    private ArrayList<String> list;

    public static void main(String[] args) {

        // Checks to see if 1 argument was passed
        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line, an output file name");
        } else {
            // Creates an object reference to LabSeven to be able to call run()
            // and pass the argument
            LabSeven lab = new LabSeven();
            lab.run(args[0]);
        }


    }

    public void run(String argument) {

        list = new ArrayList<String>();

        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.add("eight");
        list.add("nine");
        list.add("ten");

        writeListToOutputFile(argument);

    }

    public void writeListToOutputFile(String output) {

        PrintWriter outputWriter = null;

        try {
            outputWriter = new PrintWriter(new BufferedWriter(new FileWriter(output)));
            for (String element : list){
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
