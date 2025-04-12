import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FractionsGenerator {
    public static void main(String[] args) {
        try {
            File output = new File("fractionsTemp.txt");
            output.createNewFile();
            PrintWriter file = new PrintWriter(new FileOutputStream(output));
            String sep = "/";
            for (int i = 0; i < 10_000; i++) {
                file.println(
                        getRand()
                        + sep
                        + getRand()
                );
            }
            file.close();
        } catch (Exception ex) {
            System.out.println("fix me yo");
            ex.printStackTrace();
        }
    }
    private static int getRand() {
        int out = (-20 + (int) (Math.random() * 41));
        if (out == 0) out = 1;
        return out;
    }
}
