import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {
        System.out.println(sumIntegers("Java 12.3 8 10 12 18 22 35.3"));
    }

    static int sumIntegers(String s) {
        int sum = 0;
        Scanner reader = new Scanner(s);
        while (reader.hasNext()) {
            if (reader.hasNextInt()) {
                sum += reader.nextInt();
            } else {
                reader.next();
            }
        }
        return sum;
    }

    static int[][] intBox(int size) {
        int[][] out = new int[size][size];
        if (size == 0) return out;
        for (int iRow = 0; iRow < size; iRow++) {
            if (iRow == 0 || iRow == size - 1) {
                Arrays.fill(out[iRow], 1);
            }
            else {
                out[iRow][0] = 1;
                out[iRow][size - 1] = 1;
            }
        }
        return out;
    }

    private static void sumJagged2dArray() {
        int[][] array = new int[6][];
        Random random = new Random();
        for (int row = 0; row < 6; row++) {
            array[row] = new int[random.nextInt(10)];
        }
        for (int[] iRow : array) {
            for (int iIndex = 0; iIndex < iRow.length; iIndex++) {
                iRow[iIndex] = random.nextInt(10);
            }
        }

        int sum = 0;
        for (int[] iRow : array) {
            for (int iElement : iRow) {
                sum += iElement;
            }
        }
        System.out.println(Arrays.deepToString(array));
        System.out.println("sum: " + sum);
    }
}