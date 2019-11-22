package bg.sofia.course.java.core;

public class ThreadGuessDemo {

    public static void main(String[] args) {

        Runnable hello = new DisplayMessage("Hello");
        Thread thread1 = new Thread(hello);
        thread1.setName("hello");
        thread1.setDaemon(true);
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread1.start();

        Thread thread2 = new GuessANumber(27);
        thread2.start();

        System.out.println("main() is ending...");

    }
}
