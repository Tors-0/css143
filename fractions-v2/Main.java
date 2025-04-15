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
    public static Scanner console = new Scanner("fractionsTemp.txt\nquit");
    private static String filename;

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        do {
            System.out.print("Filename: ");
            filename = console.nextLine();
            if ("quit".equalsIgnoreCase(filename)) break;

            processFile();
        } while (!"quit".equalsIgnoreCase(filename));
        System.out.println("All done!");
    }

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

    private static void processFile() {
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
