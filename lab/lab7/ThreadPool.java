import java.util.LinkedList;
import java.util.Queue;

public class ThreadPool {
    private static final int THREAD_COUNT = 3;

    public static boolean buildThreadQueue() { // returns true upon success
        Queue<Thread> queue = new LinkedList<>();

        // When our program starts up, it might create multiple threads to use.
        for (int i = 0; i < THREAD_COUNT; i++) {
            queue.add(new Thread(new RunnableObject(i)));
        }

        System.out.println("Initial thread order:");
        System.out.println(queue);

        // TODO Iterate over the thread pool and call start() on each thread.
        // In a loop, dequeue each thread, call start() on it, and enqueue it again.
        //    current = get a thread
        //    current.start();
        //    put the thread back

        System.out.println("Thread order after start()ing:");
        System.out.println(queue);

        return true;  // on successful start
    }
}
