package bg.sofia.course.java.core;

public class GuessANumber extends Thread {

    private int number;

    public GuessANumber(int number) {
        this.number = number;
    }

    public void run() {
        int counter = 0;
        int guess = 0;
        do {
            guess = (int) (Math.random() * 100 + 1);
            System.out.println(this.getName() + " guesses " + guess);
            counter++;
        } while (guess != this.number);
        System.out.println("CORRECT! " + this.getName() + " guessed correctly in " + counter + " tries.");
    }
}
