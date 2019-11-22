package bg.sofia.course.java.core;

public class ThreadDemo extends Thread {

    private String threadName;
    private Thread t;

    public ThreadDemo(String name) {
        this.threadName = name;
        System.out.println("Creating " + this.threadName);
    }

    public void run() {
        System.out.println("Running " + this.threadName);

        try {
            for (int i= 5; i > 0; i--) {
                System.out.println("Thread: " + this.threadName + ", " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted: " + this.threadName);
        }

        System.out.println("Thread " + this.threadName + " exiting.");
    }

    public void threadStart() {
        System.out.println("Starting " + this.threadName);

        if (t == null) {
            t = new Thread(this, this.threadName);
            t.start();
        }
    }

}
