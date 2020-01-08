package java112.labs1;

public class LabThree {

    public static void main(String[] args) {

        // Creates an object reference to LabThree to be able to call run()
        LabThree lab = new LabThree();

        // Checks to see if an argument was passed
        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line");
        } else {
            lab.run(args[0]);
        }
    }

    // Outputs the argument that was passed through the command line
    public void run(String input) {
        System.out.println("input: " + input);
    }


}
