import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Testing {
    public static class Hello<T> {
        public Hello() {

        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println(list);

        list.remove(4);
        System.out.println("removed element at 4");

        System.out.println(list);

        list.remove((Integer) 4);
        System.out.println("removed element 4");

        System.out.println(list);
    }

    public static void biggestFamily(String filename) {
        TreeMap<String, List<String>> famMap = new TreeMap<>();

        try {
            Scanner file = new Scanner(new FileInputStream(filename));

            String[] names;
            while (file.hasNextLine()) {
                names = file.nextLine().split(" ");

                if (!famMap.containsKey(names[1])) {
                    famMap.put(names[1], new ArrayList<>());
                }
                famMap.get(names[1]).add(names[0]);
            }

            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("err" + e.getMessage());
            e.printStackTrace();
        }

        int longestFam = 0;
        List<String> remove = new ArrayList<>();
        for (String key : famMap.keySet()) {
            int len = famMap.get(key).size();
            if (len >= longestFam) {
                longestFam = len;
            }
        }

        for (String key : famMap.keySet()) {
            if (famMap.get(key).size() < longestFam) {
                remove.add(key);
            }
        }
        for (String key : remove) {
            famMap.remove(key);
        }

        for (String key : famMap.navigableKeySet()) {
            System.out.print(key + " family: ");
            for (String value : famMap.get(key).stream().sorted().toList()) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static HashMap<String, Integer> intersect(
            HashMap<String, Integer> map1,
            HashMap<String, Integer> map2
    ) {
        HashMap<String, Integer> outMap = new HashMap<>();
        for (String str : map1.keySet()) {
            if (map2.containsKey(str) && map2.get(str).equals(map1.get(str))) {
                outMap.put(str, map1.get(str));
            }
        }

        return outMap;
    }

    public static void removeDuplicates(ArrayList<String> list) {
        List<String> outList = list.stream().distinct().toList();
        list.clear();
        list.addAll(outList);
    }

    static void countDown(int n) {
        System.out.print(n + " ");
        if (n > 0) countDown(n - 1);
    }

    static String goAgain(String str, int index) {
        if (index >= str.length())
            return str;
        return str + goAgain(str.substring(index), index + 1);
    }

    // limited at n=20
    static long factorial(int n) {
        if (n == 2) return 2;
        else return n * factorial(n-1);
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