import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * A demo class that uses the {@link Fraction} class to show off its capabilities
 * @author Rae Johnston
 * @version 2025.04.10
 */
public class Main {
    /**
     * single console scanner not to be redefined in this class
     */
    public static Scanner console = new Scanner(System.in);

    /**
     * creates and runs a Main object
     * @param args command line arguments (ignored)
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    /**
     * Prompts the user for an input filename and then process it to find the
     * number of fractions equivalent to each other in the file
     */
    private void run() {
        String filename;
        do {
            System.out.print("Filename: ");
            filename = console.nextLine();
            if ("quit".equalsIgnoreCase(filename)) break;

            processFile(filename);
        } while (!"quit".equalsIgnoreCase(filename));
        System.out.println("All done!");
    }

    /**
     * Read the number of lines in a text file (probably works on other filetypes too)
     * @param filename the relative filename of the text file
     * @return the number of lines in the file
     */
    private static int readFileLength(String filename) {
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(new FileInputStream(filename));
        } catch (FileNotFoundException ex) {
            System.out.println("Error reading file");
        }
        if (fileReader == null) return 0;

        int length = 0;
        while (fileReader.hasNextLine()) {
            length++;
            fileReader.nextLine();
        }
        return length;
    }

    /**
     * Checks a file and prints out the number of equivalent fractions inside the file
     * @param filename the relative path of the file
     */
    private static void processFile(String filename) {
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(new FileInputStream(filename));
        } catch (FileNotFoundException ex) {
            System.out.println("Error reading file");
        }
        if (fileReader == null) return;

        int fileLength = readFileLength(filename);
        Fraction[] fractions = new Fraction[fileLength];

        for (int line = 0; line < fileLength; line++) {
            fractions[line] = new Fraction(fileReader.nextLine());
        }

        Fraction[] uniqueFractions = new Fraction[fileLength];
        Arrays.stream(fractions).distinct().toList().toArray(uniqueFractions);

        StringBuilder output = new StringBuilder();
        String separator = " has a count of ";
        String newLine = "\n";
        for (int i = 0; i < uniqueFractions.length; i++) {
            if (uniqueFractions[i] == null) break;
            int finalI = i;
            uniqueFractions[i].reduce();
            output.append(uniqueFractions[i]);
            output.append(separator);
            output.append(
                    Arrays.stream(fractions)
                            .filter(fraction ->
                                    fraction.equals(uniqueFractions[finalI]))
                            .count()
            );
            output.append(newLine);
        }
        System.out.println(output);
    }
}
