package bg.sofia.course.java.core;

public class DisplayMessage implements Runnable {

    private String message;

    public DisplayMessage(String msg) {
        this.message = msg;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println(this.message);
        }
    }

}
