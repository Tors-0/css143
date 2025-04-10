import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Grader {
    static Scanner console = new Scanner(System.in);
    public static void main(String[] args) {
        int numGrades = -1;
        do {
            System.out.print("How many grades do you want to enter?" +
                    "\nPlease enter a positive number: ");

            try {
                numGrades = console.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            }
            // clear scanner buffer
            console.nextLine();
        } while (numGrades < 0);

        double[] grades = new double[numGrades];
        System.out.println("Please enter the grades, separated by spaces:");

        for (int i = 0; i < numGrades; i++) {
            grades[i] = Double.parseDouble(console.next());
        }
        console.nextLine(); // clear scanner buffer

        System.out.print("What file should be written to?: ");
        String filename = console.nextLine();

        File outputFile = null;
        PrintWriter filePrinter = null;
        try {
            outputFile = new File(filename);
            outputFile.createNewFile(); // ensure the file exists
            filePrinter = new PrintWriter(new FileOutputStream(outputFile));

            for (double d : grades) {
                filePrinter.printf("%.2f %s\n", d, getLetterGrade(d));
                System.out.printf("%.2f %s\n", d, getLetterGrade(d));
            }

            double avg = average(grades);
            filePrinter.printf("Average: %.2f %s\n", avg, getLetterGrade(avg));
            System.out.printf("Average: %.2f %s\n", avg, getLetterGrade(avg));

        } catch (Exception ex) {
            System.out.println("File writing process failed: " + ex.getMessage());
        } finally {
            if (filePrinter != null) {
                filePrinter.close();
            }
        }
    }

    public static String getLetterGrade(int grade) {
        return switch ((int) (grade / 10)) {
            case 10, 9 -> "A";
            case 8 -> "B";
            case 7 -> "C";
            case 6 -> "D";
            default -> "F";
        };
    }
    /*
    a method with multiple definitions that have different parameters is called
    an overloaded method.

    switches can use the primitive data types byte, short, char, and int
     */
    public static String getLetterGrade(double grade) {
        if (grade >= 90) {
            return "A";
        } else if (grade >= 80) {
            return "B";
        } else if (grade >= 70) {
            return "C";
        } else if (grade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public static double average(double[] arr) {
        double sum = 0;
        for (double d : arr) {
            sum += d;
        }
        return sum / arr.length;
    }
}
