package interface_test;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EggsAmple eggs = new EggsAmple();

        Printable.print(eggs);

        Printable pr = new Printable() {
            @Override
            public void print1() {
                System.out.println("bye");
            }

            @Override
            public void print2() {
                System.out.println("hi");
            }
        };

        pr.print2();
        pr.print1();
    }
}
