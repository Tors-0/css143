import java.util.Scanner;


/**
 * Changes added to V3:
 * - Enable sorting in 4 different ways using Comparable and Comparator
 *    - sortaf => sort in ascending order by the Fraction
 *    - sortdf => sort in descending order by the Fraction
 *    - sortac => sort in ascending order by the counts
 *    - sortdc => sort in descending order by the counts
 * - Use a FractionContainer class to hold the Fraction and the count
 * - Use a FractionTracker class to manage most of the work
 * - Main will interact with the user and dispatch commands
 *
 */
public class Main {

    private FractionTracker tracker = null;

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public Main() {
        tracker = new FractionTracker();
    }

    public void run() {
        boolean done = false;
        Scanner console = new Scanner(System.in);
        while (!done) {
            System.out.print("Command: ");
            String filename = console.nextLine().strip();
            if (filename.equalsIgnoreCase("quit")) {
                System.out.println("All done!");
                done = true;
            } else  if (filename.length() > 0 && !UnitTestRunner.processCommand(filename, this::processCommand)) {
                System.out.println(processCommand(filename));
            }
        }
        console.close();
    }

    public String processCommand(String cmd) {
        if (cmd.equalsIgnoreCase("sortaf")) {
            // ask tracker to sort ascending by Fraction
            return tracker.toString();
        }
        if (cmd.equalsIgnoreCase("sortdf")) {
            // ask tracker to sort descending by Fraction
            return tracker.toString();
        }
        // TODO: complete the remaining commands

        return "TODO: return output. Don't print!";
    }


}

