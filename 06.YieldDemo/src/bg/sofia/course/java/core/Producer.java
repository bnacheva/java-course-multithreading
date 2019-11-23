package bg.sofia.course.java.core;

public class Producer extends Thread {

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("I am Producer: Produced item " + i);
            Thread.yield();
        }
    }

}
