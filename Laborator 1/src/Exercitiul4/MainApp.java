package Exercitiul4;

import java.util.Random;

public class MainApp {
    public static void main(String[] args) {
        Random random = new Random();
        Cmmdc cmmdc = new Cmmdc();
        int nr1, nr2;
        nr1 = random.nextInt(31);
        nr2 = random.nextInt(31);
        System.out.print(cmmdc.aflareCmmdc(nr1, nr2) + "\n");
    }
}
