public class PermanentHire extends SalariedWorker {
    private int salary;
    public static final int startingSalary = 10_000;

    private PermanentHire() {}

    public PermanentHire(String name, int social){
        super(name, social, startingSalary );
    }

    public PermanentHire(String name, int social, double monthlyPay) {
        super(name, social, monthlyPay);
    }

    @Override
    public double calculateWeeklyPay() {
        return super.calculateWeeklyPay();
    }

}
