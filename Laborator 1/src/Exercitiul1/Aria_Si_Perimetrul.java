package Exercitiul1;

import java.util.Scanner;

public class Aria_Si_Perimetrul {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lungime = ");
        int L = scanner.nextInt();
        System.out.print("Latime = ");
        int l = scanner.nextInt();
        System.out.print("Aria este: " + L * l);
    }
}
