public class Palindromes {

    public static boolean isPalindrome(String text) {
        // TODO Check if the argument is a palindrome using a LinkedStack.
        String filteredText = text.replaceAll("[^a-zA-Z]", "");
        filteredText = filteredText.toLowerCase();
        LinkedStack stack = new LinkedStack();
        for (int i = 0; i < filteredText.length(); i++) {
            stack.push(filteredText.charAt(i));
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return filteredText.contentEquals(builder);
    }

    public static boolean isPalindromeRec(String text) {
        // TODO Check if the argument is a palindrome using recursion.
        String filteredText = text.replaceAll("[^a-zA-Z]", "");
        filteredText = filteredText.toLowerCase();

        return isPalindromeRecHelper(filteredText);
    }

    private static boolean isPalindromeRecHelper(String text) {
        if (text.length() <= 1) return true;
        if (text.charAt(0) != text.charAt(text.length() - 1)) return false;
        else return isPalindromeRecHelper(text.substring(1, text.length() - 1));
    }
}