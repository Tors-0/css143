import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
            tracker.sortByFraction(true);
            return tracker.toString();
        }
        else if (cmd.equalsIgnoreCase("sortdf")) {
            // ask tracker to sort descending by Fraction
            tracker.sortByFraction(false);
            return tracker.toString();
        }
        else if (cmd.equalsIgnoreCase("sortac")) {
            tracker.sortByCount(true);
            return tracker.toString();
        }
        else if (cmd.equalsIgnoreCase("sortdc")) {
            tracker.sortByCount(false);
            return tracker.toString();
        }

        String fileResult = processFile(cmd);
        if (fileResult != null) return fileResult;
        else return tracker.toString();
    }

    /**
     * Checks a file and prints out the number of equivalent fractions inside the file
     * @param filename the relative path of the file
     */
    private String processFile(String filename) {
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(new FileInputStream(filename));
        } catch (FileNotFoundException ex) {
            return "Error reading file";
        }

        tracker.clear();

        while (fileReader.hasNextLine()) {
            tracker.add(new Fraction(fileReader.nextLine()));
        }

        return null;
    }
}

