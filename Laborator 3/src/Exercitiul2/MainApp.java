package Exercitiul2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void citireProduseDinCSV(List<Produs>produse) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/Exercitiul2/produse.csv"));
        String linie;
        while (scanner.hasNextLine()) {
            linie = scanner.nextLine();
            String[] c = linie.split(",");

            String nume = c[0];
            float pret = Float.parseFloat(c[1].trim());
            int cantitate = Integer.parseInt(c[2].trim());
            LocalDate data_ex = LocalDate.parse(c[3].trim());

            produse.add(new Produs(nume, pret, cantitate, data_ex));
        }
    }

    public static void afisareProduse(List<Produs>produse) {
        for (Produs p : produse) {
            System.out.println(p);
        }
    }

    public static void afisareProduseExpirate(List<Produs>produse) {
        for (Produs p : produse) {
            if (p.getDataExpirarii().isBefore(LocalDate.now())) {
                System.out.println(p);
            }
        }
    }

    public static void vanzareProdus(List<Produs>produse, String nume, int cantitateVanduta) {
        for (int i = 0; i < produse.size(); i++) {
            if (produse.get(i).getNume().equalsIgnoreCase(nume)) {
                if (produse.get(i).getCantitate() >= cantitateVanduta) {
                    produse.get(i).setCantitate(produse.get(i).getCantitate() - cantitateVanduta);
                    Produs.adaugaIncasari((float) (produse.get(i).getPret() * cantitateVanduta));
                    if (produse.get(i).getCantitate() == 0) {
                        produse.remove(produse.get(i));
                    }
                    break;
                } else {
                    System.out.println("Stoc insuficient.");
                    return;
                }
            }
        }
    }

    public static void afisareProduseCuPretMinim(List<Produs>produse) {
        float pretMinim = Float.MAX_VALUE;
        for (Produs p : produse) {
            if (p.getPret() < pretMinim) {
                pretMinim = (float) p.getPret();
            }
        }
        for (Produs p : produse) {
            if (p.getPret() == pretMinim) {
                System.out.println(p);
            }
        }
    }

    public static void salvareProduseCuCantitateRedusa(List<Produs>produse, int pragCantitate) throws IOException {
        List<String> produseCantitateRedusa = new ArrayList<>();
        for (Produs p : produse) {
            if (p.getCantitate() < pragCantitate) {
                produseCantitateRedusa.add(p.toString());
            }
        }

        File produseReduse = new File("src/Exercitiul2/produseCRedusa.csv");

        PrintWriter printWriter = new PrintWriter(produseReduse);
        for (String pCR : produseCantitateRedusa)
            printWriter.println(pCR);
        printWriter.close();
    }

    public static void main(String[] args) {
        List<Produs> produse = new ArrayList<>();
        try {
            citireProduseDinCSV(produse);
        } catch (FileNotFoundException e) {
            System.out.println("Eroare la citirea fisierului.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        Meniu meniu = new Meniu();
        meniu.AfisareMeniu();
        int optiune = scanner.nextInt();

        while (optiune > 0) {
            switch (optiune) {
                case 1:
                    afisareProduse(produse);
                    break;
                case 2: afisareProduseExpirate(produse);
                    break;
                case 3:
                    System.out.print("Nume produs: ");
                    String nume = scanner.next();
                    System.out.print("Cantitate: ");
                    vanzareProdus(produse, nume, scanner.nextInt());
                    break;
                case 4:
                    afisareProduseCuPretMinim(produse);
                    break;
                case 5:
                    System.out.print("Prag cantitate: ");
                    try {
                        salvareProduseCuCantitateRedusa(produse, scanner.nextInt());
                    } catch (IOException e) {
                        System.out.println("Eroare la salvare.");
                    }
                    break;
                default:
                    System.out.println("Optiune invalida.");
                    break;
            }

            meniu.AfisareMeniu();
            optiune = scanner.nextInt();
        }
    }
}
