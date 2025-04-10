import java.time.Month;
/*
Q1:
    instance variables are set to private to force other classes to use its
    setter methods, allowing for strict input validation
Q2:
    private instance variables are accessible only in instance methods of the
    class containing them
 */
public class Date {
    public static void main(String[] args) {
        Date date1 = new Date();
        Date date2 = new Date(2025, 4, 9);

        System.out.println("date1: " + date1);
        System.out.println("date1 usa: " + date1.toString(DateStyle.USA));
        System.out.println("date1 uk: " + date1.toString(DateStyle.UK));

        System.out.println("date2: " + date2);
        System.out.println("date2 usa: " + date2.toString(DateStyle.USA));
        System.out.println("date2 uk: " + date2.toString(DateStyle.UK));
    }


    private int year;
    private int day;
    private Month month;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(byte day) {
        if (day > this.month.length(year % 4 == 0)) {
            throw new IllegalArgumentException("Day outside valid range for selected month");
        } else {
            this.day = day;
        }
    }

    public int getMonth() {
        return month.getValue();
    }

    public void setMonth(int month) {
        this.month = Month.of(month);
    }

    /**
     * parameters in iso8601 format order (year, month, day)
     * @param year
     * @param month
     * @param day
     */
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = Month.of(month);
        if (day > this.month.length(year % 4 == 0)) {
            throw new IllegalArgumentException("Day outside valid range for selected month");
        } else {
            this.day = day;
        }
    }
    public Date() {
        this.year = 1975;
        this.month = Month.JANUARY;
        this.day = 1;
    }

    @Override
    public String toString() {
        return toString(null);
    }
    public String toString(DateStyle style) {
        switch (style) {
            case USA:
                return month.name() + " " + day + ", " + year;
            case UK:
                return day + " " + month.name() + ", " + year;
            case ISO8601:
            case null, default:
                return String.format("%04d-%02d-%02d", year, month.getValue(), day);
        }
    }

    public enum DateStyle {
        USA,
        UK,
        ISO8601
    }
}
