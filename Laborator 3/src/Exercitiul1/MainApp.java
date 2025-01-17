package Exercitiul1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        List<Parabola> parabole = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("in.txt"))) {
            while (scanner.hasNextInt()) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int c = scanner.nextInt();
                parabole.add(new Parabola(a, b, c));
            }
        } catch (IOException e) {
            System.out.println("Eroare la citirea fisierului: " + e.getMessage());
        }

        for (Parabola p : parabole) {
            System.out.println("f(x) = " + p.getA() + "x^2 + " + p.getB() + "x + " + p.getC());
            p.afiseazaVarf();
        }

        for (int i = 0; i < parabole.size() - 1; i++) {
            parabole.get(i).afiseazaMijlocSiDistanta(parabole.get(i + 1));
        }
    }
}
