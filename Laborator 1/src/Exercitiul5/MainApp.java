package Exercitiul5;

import java.util.Random;

public class MainApp {
    public static void main(String[] args) {
        Random random = new Random();
        int nr;
        nr = random.nextInt(21);
        Fibonacci sirFib = new Fibonacci();
        sirFib.sirulFiboncci(1,1, nr);
    }
}
