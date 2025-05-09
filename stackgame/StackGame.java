import java.util.Scanner;
import java.util.Stack;

class StackGame {
    public static Scanner console = new Scanner(System.in);

    // Declare our questions and stack fields
    public static String[] questions = {
            "What is the size of the stack?",
            "What will pop() return?",
            "What is the item at index %d?"
        };
    private Stack<Integer> stack;
    
    public static void main(String[] args) {
        StackGame game = new StackGame();
        game.play();
    }

    public StackGame() {
        stack = new Stack<>();
    }
    
    public void play() {      
        // ask how many times to loop (helper method anyone?)
        int times = getTimes();

        performOperations(times);
        
        String[] qna = getQuestionAndAnswer();
        
        // Start a StopWatch timer, get input, then stop watch
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println(qna[0]);
        String guess = StackGame.console.nextLine();
        watch.stop();

        // output the results
        boolean isCorrect = guess.equals(qna[1]); 
        String correct = isCorrect ? "CORRECT" : "WRONG";
        System.out.printf("You got it %s in %s\n", correct, watch);
        if (!isCorrect) {
            System.out.printf("The correct answer is: %s\n", qna[1]);
        }
    }

    /**
     * Perform appropriate stack operations on the stack.
     * Print the operation performed for the user to see.
     * @param num The number of operations.
     */
    private void performOperations(int num) {
       // Loop num times, altering the stack each iteration.
       // Print the operation for the user to see.
       for (int i = 0; i < num; i++) {
          
           // randomly decide push or pop.
           // But, push more often than pop so our stack grows.
           boolean push = (Math.random() > 0.2);
           
           // assure push if our stack is empty
           push |= stack.empty();
           
           // If push, pick a random number [0, 10]
           // Inform use of of the operation specifics
           // And do the operation on the stack
           if (push) {
               Integer value = (int) (Math.random() * 11);
               System.out.printf("push(%d)\n", value);
               stack.push(value);
           } else {
               System.out.println("pop()");
               stack.pop();
           }
       }
    }
    
    /**
     * Prompt the user for the number of iterations to perform.
     * Repeat prompt until we get an integer > 0.
     * @return integer > 0
     */
    private int getTimes() {
        boolean done = false;
        int times = 0;
        while (!done) {
            System.out.print("How many iterations? ");
            String input = StackGame.console.nextLine();
            try {
                times = Integer.parseInt(input);
                done = (times > 0);
            } catch (NumberFormatException e) {
                System.out.println("Please input a number > 0");
            }
        }
        
        return times;
    }

    /**
     * Get a random question along with the answer.
     * The question will be one of the following:
     *    "What is the size of the stack?"
     *    "What will pop() return?" (only if not empty)
     *    "What is the value at index n" (where n >=1 && n < size) (if not empty)
     * @return String array: { question, answer }
     */
    private String[] getQuestionAndAnswer() {
        int rand;
        String question;
        String answer;
        int nth = 0;
        do {
            // don't allow a pop() || index question if stack is empty
            rand = (int) (Math.random() * 3);    
        } while (rand != 0 && stack.empty());

        if (rand == 2) {
            nth = (int) (Math.random() * stack.size());     
            question = String.format(StackGame.questions[2], nth);
        } else {
            question = questions[rand];
        }

        // Form the answer
        switch (rand) {
            case 0: // size of the stack
                answer = stack.size() + "";
                break;
            case 1: // what will pop
                answer = stack.pop() + "";
                break;
            case 2: // nth item
            default:
                // our stack is zero-based.
                answer = stack.get(nth) + "";
                break;
        };

        // return the Q and A pair
        return new String[] { question, answer };
    }
}