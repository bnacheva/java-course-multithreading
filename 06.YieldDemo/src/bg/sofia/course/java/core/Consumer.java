package bg.sofia.course.java.core;

public class Consumer extends Thread {

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("I am Consumer: Consumed item " + i);
            Thread.yield();
        }
    }

}
