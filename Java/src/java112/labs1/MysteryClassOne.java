package java112.labs1;

/** Mystery Class One provides practice with TDD.  The class will display a number
 * @author djcadd
 */

public class MysteryClassOne {

    // Main method that creates an instance of MysteryClassOne to call and output the value
    public static void main(String[] args) {
        MysteryClassOne lab = new MysteryClassOne();
        System.out.println("The method returned: " + lab.mysteryMethodOne());
    }

    // Method that returns the value of 1
    public int mysteryMethodOne() {
        return 1;
    }

}
