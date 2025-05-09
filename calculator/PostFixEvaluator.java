import java.nio.charset.MalformedInputException;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

public class PostFixEvaluator {

    public static double evaluatePostFix(Queue<Token> tokens) throws ArithmeticException, IllegalArgumentException {
        Stack<Token> stack = new Stack<Token>();
        Iterator<Token> queue = tokens.iterator();

        Token currToken;
        Token left;
        Token right;
        while (queue.hasNext()) {
            currToken = queue.next();
            if (currToken.isNumber()) {
                stack.push(currToken);
            } else if (currToken.isOperator()) {
                right = stack.pop();
                left = stack.pop();

                stack.push(evaluateOp(left, currToken, right));
            }
        }

        if (stack.peek() == null) {
            throw new IllegalArgumentException("Malformed postfix expression");
        }
        return stack.pop().getNumber();
    }

    private static Token evaluateOp(Token left, Token op, Token right) throws ArithmeticException, IllegalArgumentException {
        double leftNum = left.getNumber();
        double rightNum = right.getNumber();
        switch (op.getOperator()) {
            case "+" -> {
                return new Token(leftNum + rightNum);
            }
            case "-" -> {
                return new Token(leftNum - rightNum);
            }
            case "/", "÷" -> {
                return new Token(leftNum / rightNum);
            }
            case "*", "x" -> {
                return new Token(leftNum * rightNum);
            }
            case "^" -> {
                return new Token(Math.pow(leftNum, rightNum));
            }
            case "%" -> {
                return new Token(leftNum % rightNum);
            }
            default -> {
                throw new IllegalArgumentException("Invalid operator in expression");
            }
        }
    }
}