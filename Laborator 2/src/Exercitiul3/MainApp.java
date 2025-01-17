package Exercitiul3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {
    public static String inserare(String propozitie, int index, String nouSirAdaugat) throws StringIndexOutOfBoundsException{
        StringBuilder stringBuilder = new StringBuilder(propozitie);
        stringBuilder.insert(index, nouSirAdaugat);
        return stringBuilder.toString();
    }

    public static String stergere(String propozitie, int start, int end) throws StringIndexOutOfBoundsException{
        StringBuilder stringBuilder = new StringBuilder(propozitie);
        stringBuilder.delete(start, end);
        return stringBuilder.toString();
    }

    public static void inserted() throws InputMismatchException
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceti o propozitie: ");
        String sir = scanner.nextLine();

        System.out.print("Introduceti o pozitie: ");
        int numar = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Introduceti propozitia pe care doriti sa o inserati: ");
        String sirNou = scanner.nextLine();

        System.out.println(inserare(sir, numar, sirNou));
    }

    public static void deleted() throws InputMismatchException
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceti o propozitie: ");
        String sir = scanner.nextLine();

        System.out.println("Introduceti potiunea de sir pe care doriti sa o stergeti: ");
        System.out.println("Pozitia de la care incepe stergerea: ");
        int start;
        start = scanner.nextInt();


        System.out.println("Pozitia la care se termina stergerea: ");
        int end;
        end = scanner.nextInt();

        System.out.println(stergere(sir, start, end));
    }

    public static void main(String[] args) {
        inserted();
        deleted();
    }
}
