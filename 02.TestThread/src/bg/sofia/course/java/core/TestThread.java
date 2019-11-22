package bg.sofia.course.java.core;

public class TestThread {

    public static void main(String[] args) {
        ThreadDemo T1 = new ThreadDemo("TheadDemo 1");
        T1.threadStart();

        ThreadDemo T2 = new ThreadDemo("TheadDemo 2");
        T2.threadStart();
    }
}
