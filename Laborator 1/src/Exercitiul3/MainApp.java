package Exercitiul3;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.print("Introduceti un numar: ");
        n = scanner.nextInt();
        Divizori divizor = new Divizori();
        if(divizor.nrPrim(n) == 1)
            divizor.afisareDivizori(n);
        else if(divizor.nrPrim(n) == 2)
            System.out.println("Numarul nu este prim.");
        else
            System.out.println("Numarul este prim.");
    }
}
