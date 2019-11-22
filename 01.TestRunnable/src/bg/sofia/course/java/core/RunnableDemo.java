package bg.sofia.course.java.core;

public class RunnableDemo implements Runnable {

    private String threadName;
    private Thread t;

    public RunnableDemo(String name) {
        this.threadName = name;
        System.out.println("Creating " + this.threadName);
    }

    @Override
    public void run() {
        System.out.println("Running " + this.threadName);

        try {
            for (int i= 5; i > 0; i--) {
                System.out.println("Thread: " + this.threadName + ", " + i);
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted: " + this.threadName);
        }

        System.out.println("Thread " + this.threadName + " exiting.");
    }

    public void runnableStart() {
        System.out.println("Starting " + this.threadName);

        if (t == null) {
            t = new Thread(this, this.threadName);
            t.start();
        }
    }

}
