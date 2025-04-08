import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner console = new Scanner(System.in);
    private static String filename;

    public static void main(String[] args) {
        do {
            System.out.print("Filename: ");
            filename = console.nextLine();
            if ("quit".equalsIgnoreCase(filename)) break;

            processFile();
        } while (!"quit".equalsIgnoreCase(filename));
        System.out.println("All done!");
    }

    private static void processFile() {
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(new FileInputStream(filename));
        } catch (FileNotFoundException ex) {
            System.out.println("Error reading file");
        }
        if (fileReader == null) return;

        StringBuilder rawFile = new StringBuilder();
        while (fileReader.hasNextLine()) {
            rawFile.append(fileReader.nextLine()).append("\n");
        }

        String[] fractions = rawFile.toString().split("\n");
        int uniqueFracs = 1;

        for (int i = 0; i < fractions.length; i++) {
            for (int j = 0; j < i; j++) {
                String[] current = fractions[i].split("/");
                String[] check = fractions[j].split("/");

                int a = Integer.parseInt(current[0]);
                int b = Integer.parseInt(current[1]);
                int c = Integer.parseInt(check[0]);
                int d = Integer.parseInt(check[1]);

                if (a*d == b*c) {
                    fractions[i] = fractions[j];
                } else {
                    uniqueFracs++;
                }
            }
        }

        String[] seenFracs = new String[uniqueFracs];
        int seenFracsNextIndex = 0;
        Arrays.fill(seenFracs, "");

        for (String frac : fractions) {
            boolean unique = true;
            for (String check : seenFracs) {
                if (check.equals(frac)) {
                    unique = false;
                    break;
                }
            }

            if (!unique) continue;

            int thisFracCount = 0;
            for (String check : fractions) {
                if (frac.equals(check)) thisFracCount++;
            }

            System.out.println(frac + " has a count of " + thisFracCount);
            seenFracs[seenFracsNextIndex] = frac;
            seenFracsNextIndex++;
        }
    }
}
