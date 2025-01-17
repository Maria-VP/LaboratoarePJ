package Exercitiul4;

import java.time.LocalDate;
import java.util.Scanner;

public class MainApp {

    public static int citesteNrPersoane() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti numarul de persoane: ");
        return scanner.nextInt();
    }

    public static String citesteNumele() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti numele persoanei: ");
        return scanner.next();
    }

    public static String citesteCNP() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Introduceti CNP-ul: ");
            String cnp = scanner.next();
            if (validareCNP(cnp)) {
                return cnp;
            } else {
                System.out.println("CNP invalid! Mai incercati o data.");
            }
        }
    }

    public static boolean validareCNP(String cnp) {
        if (cnp.length() != 13) return false;

        if (!cnp.matches("\\d{13}")) return false;

        if (!(cnp.startsWith("1") || cnp.startsWith("2") || cnp.startsWith("5") || cnp.startsWith("6"))) return false;

        int[] control = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
        int suma = 0;

        for (int i = 0; i < 12; i++) {
            suma += (cnp.charAt(i) - '0') * control[i];
        }

        int cifraControl = suma % 11;
        if (cifraControl == 10) cifraControl = 1;

        return cifraControl == (cnp.charAt(12) - '0');
    }

    public static void AfisarePersoane(Persoana[] persoane) {
        for (Persoana persoana : persoane) {
            System.out.println("Nume: " + persoana.getNume());
            System.out.println("CNP: " + persoana.getCnp());
            System.out.println("Varsta: " + persoana.getVarsta());
        }
    }

    public static void main(String[] args) {
        int nrPersoane = citesteNrPersoane();
        Persoana[] persoane = new Persoana[nrPersoane];
        LocalDate dataCurenta = LocalDate.now();

        for (int i = 0; i < nrPersoane; i++) {
            System.out.println("Introduceti datele:");
            String nume = citesteNumele();
            String cnp = citesteCNP();

            String anStr = cnp.substring(1, 3);
            String lunaStr = cnp.substring(3, 5);
            String ziStr = cnp.substring(5, 7);

            int secol = (cnp.charAt(0) == '1' || cnp.charAt(0) == '2') ? 1900 : 2000;
            int anNastere = secol + Integer.parseInt(anStr);
            int luna = Integer.parseInt(lunaStr);
            int zi = Integer.parseInt(ziStr);

            LocalDate dataNasterii = LocalDate.of(anNastere, luna, zi);
            int varsta = dataCurenta.getYear() - dataNasterii.getYear();
            if (dataCurenta.getDayOfYear() < dataNasterii.getDayOfYear()) {
                varsta--;
            }

            persoane[i] = new Persoana(nume, cnp, varsta);
        }

        AfisarePersoane(persoane);
    }
}
