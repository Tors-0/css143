public class Consultant extends HourlyWorker {
    private Consultant() {}

    public Consultant(String name, int social){
        // default to minimum wage
        super(name, social, 3 );
    }

    @Override
    public double calculateWeeklyPay() {
        // the hourly worker class calculates according to 40 hours worked, so we can divide it by 2 for 20 hours worked
        return super.calculateWeeklyPay() / 2;
    }
}
