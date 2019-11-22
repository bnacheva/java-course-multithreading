package bg.sofia.course.java.core;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(100);

        System.out.println(atomicInteger.addAndGet(2));

        System.out.println(atomicInteger.getAndAdd(2));

        System.out.println(atomicInteger);

        boolean isSuccessful = atomicInteger.compareAndSet(104, 110);

        System.out.println(isSuccessful);
        System.out.println(atomicInteger);

        isSuccessful = atomicInteger.compareAndSet(104, 120);

        System.out.println(isSuccessful);
        System.out.println(atomicInteger);
    }
}
