package bg.sofia.course.java.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiTaskExecutor {

    public static void main(String[] args) {
        BlockingQueue<Runnable> worksQueue = new ArrayBlockingQueue<Runnable>(10);
        RejectedExecutionHandler rejectionHandler = new RejectedExecutionHandlerImpl();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 10, TimeUnit.SECONDS, worksQueue, rejectionHandler);

        executor.prestartAllCoreThreads();

        List<Runnable> taskGroup = new ArrayList<>();
        taskGroup.add(new TaskOne());
        taskGroup.add(new TaskTwo());
        taskGroup.add(new TaskThree());

        worksQueue.add(new MultiRunnable(taskGroup));
    }
}

class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable runnable,
                                  ThreadPoolExecutor executor) {
        System.out.println(runnable.toString() + " : I've been rejected ! ");
    }
}
