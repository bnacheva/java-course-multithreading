package bg.sofia.course.java.core;

import java.util.List;

public class Consumer implements Runnable {

    private final List<Integer> taskQueue;

    public Consumer(List<Integer> sharedQueue) {
        this.taskQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException {
        synchronized(this.taskQueue) {
            while (this.taskQueue.isEmpty()) {
                System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting, size: " + this.taskQueue.size());
                this.taskQueue.wait();
            }
            int consumedValue = (Integer) this.taskQueue.remove(0);
            System.out.println("Consumed: " + consumedValue);
            this.taskQueue.notifyAll();
        }
    }

}
