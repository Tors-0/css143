import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Lab7Driver {
    public static void main(String[] args) {
//        System.out.println("Testing the Stack class.");
//        stackTest();

//        System.out.println("Testing the Queue interface.");
//        queueTest();

        // TODO Describe the difference between the queue and stack outputs
        // adding and then removing everything to a stack reverses the order of the data
        // while doing so with a queue preserves the original order

        System.out.println("Testing the LinkedStack class.");
        linkedStackTest();

        System.out.println("Testing the LinkedQueue class.");
        linkedQueueTest();

        System.out.println("Testing the Palindromes class.");
        palindromesTest();

//        System.out.println("Testing the RoyalSuitors class.");

//        ThreadPool.buildThreadQueue();
    }

    /**
     * Demonstrates some behavior of the Stack class from the Java API.
     */
    public static void stackTest() {
        Stack<Object> list = new Stack<>();

        list.push('R');
        list.push('a');
        list.push('c');
        list.push('e');

        System.out.println("Size: " + list.size());
        while(!list.isEmpty()) {
            System.out.println(list.pop());
        }
    }

    /**
     * Demonstrates some behavior of the Queue interface from the Java API.
     */
    public static void queueTest() {
        // TODO Refer the code from stackTest and modify it to work with a queue.
        Queue<Object> list = new LinkedList<>();

        list.add('R');
        list.add('a');
        list.add('c');
        list.add('e');

        System.out.println("Size: " + list.size());
        while(!list.isEmpty()) {
            System.out.println(list.remove());
        }
    }

    public static void linkedStackTest() {
        // input data for testing
        String target = "Somethings!";
        String palindrome = "a man a plan a canal panama";

        LinkedStack list = new LinkedStack();
        // objects to be added to list
        Object object1 = target.charAt(4);
        Object object2 = target.charAt(1);
        Object object3 = target.charAt(2);
        Object object4 = target.charAt(9);
        Object object20 = target.charAt(6);  // will not be added to list

        // Adds four objects to the linked list.
        list.push(object1);
        list.push(object2);
        list.push(object3);
        list.push(object4);

        // make sure all are added
        System.out.println("My list has " + list.size() + " nodes.");
        // display the newly created list
        list.print();
        System.out.println("toString = " + list.toString());

        // test findData() here
//        LinkedStack.Node itemFound = list.findData(object1);
//        System.out.println("Item found: " + itemFound.data);

        // Test contains() here
        if (list.contains(object1))
            System.out.println("Object1 found.");
        else
            System.out.println("There is NO object1.");

        if (list.contains(object20))
            System.out.println("Object20 found.");
        else
            System.out.println("There is NO object20.");

        // Creating a new linked list by iteration using different input
        LinkedStack linkedList = new LinkedStack();

        for (int i = 0; i < palindrome.length(); i++) {
            Object object = palindrome.charAt(i);
            linkedList.push(object);
        }
        // Display your list now
        linkedList.print();

        // More tests; size() and is Empty()
        System.out.println("This time my list has " + linkedList.size() + " nodes.");
        System.out.println("Is our linkedList empty? " + linkedList.isEmpty());

        // Creating an Object of different class to compare with Character class
        Object mismatchObject = Character.getNumericValue(target.charAt(0));

        boolean areEqual = linkedList.equals(mismatchObject);
        System.out.println("Are the 2 objects equal? " + areEqual);

        boolean areEqualAgain = linkedList.equals(linkedList);
        System.out.println("Are the 2 objects equal? " + areEqualAgain);

        // test deleteHead()
        list.pop();
        if (list.contains(object4))
            System.out.println("Object4 found.");
        else
            System.out.println("Object4 has been deleted!");
        while (!list.isEmpty()) {
            list.pop();
        }
        System.out.println("Start of list:");
        list.print();
        System.out.println("End of list.");

        System.out.println("In the beginning linkedList has " + linkedList.size() + " nodes");
        linkedList.clear();

        System.out.println("After testing clear(), linkedList has " + linkedList.size() + " nodes");
    }

    public static void linkedQueueTest() {
        // input data for testing
        String target = "Somethings!";
        String palindrome = "a man a plan canal panama";

        LinkedQueue list = new LinkedQueue();
        // objects to be added to list
        Object object1 = target.charAt(4);
        Object object2 = target.charAt(1);
        Object object3 = target.charAt(2);
        Object object4 = target.charAt(9);
        Object object20 = target.charAt(6); // will not be added to list

        // add 4 objects to our linked list
        list.offer(object1);
        list.offer(object2);
        list.offer(object3);
        list.offer(object4);

        // make sure all are added
        System.out.println("My list has " + list.size() + " nodes.");

        //testing equals
        LinkedQueue list2 = new LinkedQueue();
        // add 4 objects to the new linked list
        list2.offer(object1);//t
        list2.offer(object2);//o
        list2.offer(object3);//m
        list2.offer(object4);//s
        boolean isEqual2 = list.equals(list2);
        System.out.println("list2 is equal to list1? " + isEqual2);

        // add 4 objects to our linked list in a different order
        LinkedQueue list3 = new LinkedQueue();
        list3.offer(object3);//m
        list3.offer(object1);//t
        list3.offer(object2);//o
        list3.offer(object4);//s
        boolean isEqual3 = list.equals(list3);
        System.out.println("list3 is equal to list1? " + isEqual3);

        // testing isEmpty() and poll()
        while (!list.isEmpty()) {
            Object temp = list.poll();
            System.out.println("Polling " + temp);
        }
    }

    public static void palindromesTest() {
        String s1 = "food"; // not a palindrome
        String s2 = "racecar"; // a palindrome

        System.out.println("String1 is \"" + s1 + "\"");
        System.out.println("String2 is \"" + s2 + "\"");

        System.out.println(s1 + " is a palindrome: " + Palindromes.isPalindrome(s1));
        System.out.println(s2 + " is a palindrome: " + Palindromes.isPalindrome(s2));

        //System.out.println(s1 + " is a palindrome(recursively): " + Palindromes.isPalindromeRec(s1));
        //System.out.println(s2 + " is a palindrome(recursively): " + Palindromes.isPalindromeRec(s2));
    }

    public static void royalSuitorsTest() {
        int n = 6;
        System.out.println("For " + n + " suitors, stand in place " + RoyalSuitors.findPlaceToStand(n));

        n = 10;
        System.out.println("For " + n + " suitors, stand in place " + RoyalSuitors.findPlaceToStand(n));
    }

    public static void royalSuitorsStackTest() {
        int n = 6;
        int place = RoyalSuitors.findPlaceToStandWithStack(n);
        System.out.println("For " + n + " suitors, stand in place " + place);

        n = 6;
        place = RoyalSuitors.findPlaceToStandWithStack(n);
        System.out.println("For " + n + " suitors, stand in place " + place);
    }
}
