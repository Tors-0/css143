import java.util.*; 
/*
 * InFixCalc, V0.0 (concept borrowed from Carol Zander's Infix Calculator)
 * Exercise author: Rob Nash
 * Complete the calculate() function below to build a simple, infix
 * calculator that evaluates a compound expression from left to right,
 * regardless of operator precedence
 *
 * Example: " 1 * -3 + 6 / 3"
 * Execution: calculate 1 * -3 first, then -3 + 6 next, then 3 / 3
 * last to obtain the value 1
*
* Solution by Rae Johnston
*/
public class InFixCalc {
    //example pattern: "3 + 5"
    //general pattern: <lhs='3'> <operation='+'> <rhs='5'> //extended pattern:     ...  
    //special case: 
    //other special cases?

    public static void main(String[] args) {
//        String input = "4 + 4";
//        String input = "4 + 4 / 2";
//        String input ="1 * -3";
        String input = "1 * -3 + 6 / 3";
//        String input ="5";
//        String input ="-5";
        int answer = calculate(input);
        System.out.println("Answer is " + answer);
    }

    //preconditions: all binary operations are separated via a space
    //postconditions: returns the result of the processed string
    public static int calculate(String input) {
        int lhs = 0; //short for left-hand side
        int rhs = 0; //short for right-hand side
        char operation;
        // Rae Johnston
        Scanner inputRead = new Scanner(input);

        lhs = Integer.parseInt(inputRead.next());
        while (inputRead.hasNext()) {
            operation = inputRead.next().charAt(0);
            rhs = Integer.parseInt(inputRead.next());

            switch (operation) {
                case '+' -> {
                    lhs += rhs;
                }
                case '-' -> {
                    lhs -= rhs;
                }
                case '*' -> {
                    lhs *= rhs;
                }
                case '/' -> {
                    if (rhs != 0) {
                        lhs /= rhs;
                    } else {
                        System.out.println("Invalid division operation");
                    }
                }
            };
        }

        return lhs;
    }
}
