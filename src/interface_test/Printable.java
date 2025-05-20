package interface_test;

public interface Printable {
    void print1();
    void print2();
    static void print(Printable p) {
        p.print1();
        p.print2();
    }
}
