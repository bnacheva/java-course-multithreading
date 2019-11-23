package bg.sofia.course.java.core;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerExample {

    public static void main(String[] args) {
        List<Integer> taskQueue = new ArrayList<Integer>();
        int maxCapacity = 5;

        Thread producerThread = new Thread(new Producer(taskQueue, maxCapacity), "Producer");
        Thread consumerThread = new Thread(new Consumer(taskQueue), "Consumer");

        producerThread.start();
        consumerThread.start();
    }
}
