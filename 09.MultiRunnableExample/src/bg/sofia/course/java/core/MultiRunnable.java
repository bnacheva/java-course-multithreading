package bg.sofia.course.java.core;

import java.util.List;

public class MultiRunnable implements Runnable {

    private final List<Runnable> runnable;

    public MultiRunnable(List<Runnable> runnable) {
        this.runnable = runnable;
    }

    @Override
    public void run() {
        for (Runnable runnable : this.runnable) {
            new Thread(runnable).start();
        }
    }
}
