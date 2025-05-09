import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ShuntingYard {


    public static Queue<Token> createPostFix(Queue<Token> inFix) {
        Queue<Token> output = new LinkedList<>();
        Stack<Token> stack = new Stack<>();

        Token e;
        while (inFix.peek() != null) {
            e = inFix.poll();
            if (e.isNumber()) {
                output.add(e);
            } else if (e.isOpenParen()) {
                stack.push(e);
            } else if (e.isCloseParen()) {
                while (!stack.peek().isOpenParen()) {
                    output.add(stack.pop());
                }
                stack.pop();
            } else {
                while (!canAddToStack(e, stack)) {
                    output.add(stack.pop());
                }
                stack.push(e);
            }
        }
        while (!stack.isEmpty()) {
            output.add(stack.pop());
        }

        return output;
    }

    public static boolean canAddToStack(Token e, Stack<Token> stack) {
        if (stack.isEmpty()) {
            return true;
        } else if (stack.peek().isOpenParen()) {
            return true;
        } else if (stack.peek().isOperator() || stack.peek().isFunction()) {
            return opEmmdasVal(e.toString()) > opEmmdasVal(stack.peek().toString());
        }
        return false;
    }

    public static int opEmmdasVal(String op) {
        return switch (op) {
            case "+", "-" -> 0;
            case "%", "/", "*", "÷", "x" -> 1;
            case "^", "√", "ln" -> 2;
            default -> throw new IllegalArgumentException("Invalid operator in inFix");
        };
    }
}