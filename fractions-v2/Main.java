import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner console = new Scanner(System.in);
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

        int uniqueFracs = 1;

        for (int i = 0; i < fractions.length; i++) {
            for (int j = 0; j < i; j++) {
                if (fractions[i].equals(fractions[j])) {
                    fractions[i] = fractions[j];
                } else {
                    uniqueFracs++;
                }
            }
        }

        Fraction[] seenFracs = new Fraction[uniqueFracs];
        int seenFracsNextIndex = 0;

        for (Fraction frac : fractions) {
            boolean unique = true;
            for (Fraction check : seenFracs) {
                if (frac.equals(check)) {
                    unique = false;
                    break;
                }
            }

            if (!unique) continue;

            int thisFracCount = 0;
            for (Fraction check : fractions) {
                if (frac.equals(check)) thisFracCount++;
            }

            frac.reduce();
            System.out.println(frac + " has a count of " + thisFracCount);
            seenFracs[seenFracsNextIndex] = frac;
            seenFracsNextIndex++;
        }
    }
}
