public class RunnableObject implements Runnable {
    private final String name;

    public RunnableObject(int number) {
        name = "Thread " + number;
    }

    /**
     * No need to edit anything below here, unless you'd like to
     * change the behaviour of each thread in the thread pool above.
     */
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(name + ": " + i + "th iteration");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // do nothing here
            }
        }
    }
}
