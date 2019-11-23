package bg.sofia.course.java.core;

import java.util.List;

public class Producer implements Runnable {

    private final List<Integer> taskQueue;
    private final int capacity;

    @org.jetbrains.annotations.Contract(pure = true)
    public Producer(List<Integer> sharedQueue, int size) {
        this.taskQueue = sharedQueue;
        this.capacity = size;
    }

    @Override
    public void run() {
        int counter = 0;
        while (true) {
            try {
                Thread.sleep(1000);
                produce(counter++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void produce(int i) throws InterruptedException {
        synchronized (this.taskQueue) {
            while(this.taskQueue.size() == capacity) {
                System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting, size: " + this.taskQueue.size());
                this.taskQueue.wait();
            }
            this.taskQueue.add(i);
            System.out.println("Produced: " + i);
            this.taskQueue.notifyAll();
        }
    }

}
