package bg.sofia.course.java.core;

import org.jetbrains.annotations.Contract;

import java.util.Date;

public class Task implements Runnable {

    private String name;

    @Contract(pure = true)
    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void run() {
        try {
            System.out.println("Doing a task during : " + this.name + " - Time - " + new Date());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
