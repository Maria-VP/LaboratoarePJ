package Firma_echipamente_electronice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void Citire_Din_Fisier(List<Echipament>e) throws FileNotFoundException{
        Scanner scanner = new Scanner(new File("src/Firma_echipamente_electronice/electronice.txt"));

        CreareImprimanta CI = new CreareImprimanta();
        CreareCopiator CC = new CreareCopiator();
        CreareSistemCalcul CSDC = new CreareSistemCalcul();

        while (scanner.hasNextLine()){
            String[] linie = scanner.nextLine().split(";");
            if(linie[5].equals("imprimanta"))
                e.add(CI.Creare_Imprimanta(linie));
            else if (linie[5].equals("copiator"))
                e.add(CC.Creare_Copiator(linie));
            else if (linie[5].equals("sistem de calcul"))
                e.add(CSDC.Creare_Sistem_De_Calcul(linie));
        }
    }

    public static void MeniulStarilor(){
        System.out.println("1. Achizitionat");
        System.out.println("2. Expus");
        System.out.println("3. Vandut");
        System.out.println("Alege starea: ");
    }

    public static void Setare_Stare_Echipamente(List<Echipament>echipament){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceti numele echipamentului (imprimante/copiatoare/sisteme de calcul: ");
        String nume = scanner.nextLine();

        MeniulStarilor();
        Echipament.Situatie starea;

        System.out.print("Alege starea: ");
        String s = scanner.next();
        starea = Echipament.Situatie.valueOf(s);

        switch (starea){
            case achizitionat:
                System.out.println("Actualizare: ");
                echipament.forEach(e -> {
                    if ((nume.equalsIgnoreCase("imprimante") && e instanceof Imprimante) ||
                            (nume.equalsIgnoreCase("copiatoare") && e instanceof Copiatoare) ||
                            (nume.equalsIgnoreCase("sisteme de calcul") && e instanceof Sisteme_De_Calcul)){
                        e.setSituatie(Echipament.Situatie.achizitionat);
                        System.out.println(e + "\n\n");
                    }
                });
                break;
            case expus:
                System.out.println("Actualizare: ");
                echipament.forEach(e -> {
                    if ((nume.equalsIgnoreCase("imprimante") && e instanceof Imprimante) ||
                            (nume.equalsIgnoreCase("copiatoare") && e instanceof Copiatoare) ||
                            (nume.equalsIgnoreCase("sisteme de calcul") && e instanceof Sisteme_De_Calcul)){
                        e.setSituatie(Echipament.Situatie.expus);
                        System.out.println(e + "\n\n");
                    }
                });
                break;
            case vandut:
                System.out.println("Actualizare: ");
                echipament.forEach(e -> {
                    if ((nume.equalsIgnoreCase("imprimante") && e instanceof Imprimante) ||
                            (nume.equalsIgnoreCase("copiatoare") && e instanceof Copiatoare) ||
                            (nume.equalsIgnoreCase("sisteme de calcul") && e instanceof Sisteme_De_Calcul)){
                        e.setSituatie(Echipament.Situatie.vandut);
                        System.out.println(e + "\n\n");
                    }
                });
                break;
            default:
                System.out.println("Optiune necunoscuta!");
        }
    }

    public static void MeniulModurilorDeTiparire(){
        System.out.println("Alb_Negru");
        System.out.println("Color");
    }

    public static void Setare_Mod_Tiparire(List<Echipament>echipament){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Imprimanta: ");
        String nume = scanner.nextLine();

        MeniulModurilorDeTiparire();
        Imprimante.Mod_Tiparire mod_tiparire;

        System.out.println("Alege modul de tiparire: ");
        String mt = scanner.next().toLowerCase();
        mod_tiparire = Imprimante.Mod_Tiparire.valueOf(mt);

        switch (mod_tiparire){
            case alb_negru:
                echipament.forEach(e -> {
                    if (nume.equalsIgnoreCase(e.getDenumire()) && e instanceof Imprimante){
                        ((Imprimante)e).setMod_Tiparire(Imprimante.Mod_Tiparire.alb_negru);

                        System.out.println("Actualizare: ");
                        System.out.println(e + "\n\n");
                    }
                });
                break;
            case color:
                echipament.forEach(e -> {
                    if (nume.equalsIgnoreCase(e.getDenumire()) && e instanceof Imprimante){
                        ((Imprimante)e).setMod_Tiparire(Imprimante.Mod_Tiparire.color);

                        System.out.println("Actualizare: ");
                        System.out.println(e + "\n\n");
                    }
                });
                break;
            default:
                System.out.println("Optiune necunoscuta!");
        }
    }

    public static void MeniulFormatelor(){
        System.out.println("A3");
        System.out.println("A4");
    }

    public static void Setare_Format_Copiatoare(List<Echipament>echipament) {
        Scanner scanner = new Scanner(System.in);

        MeniulFormatelor();
        Copiatoare.Format format;

        System.out.println("Alege formatul: ");
        String f = scanner.next();
        format = Copiatoare.Format.valueOf(f);

        switch (format) {
            case A3:
                echipament.forEach(e -> {
                    if (e instanceof Copiatoare){
                        ((Copiatoare) e).setFormat(Copiatoare.Format.A3);
                        System.out.println(e + "\n\n");
                    }
                });
                break;
            case A4:
                echipament.forEach(e -> {
                    if (e instanceof Copiatoare){
                        ((Copiatoare) e).setFormat(Copiatoare.Format.A4);
                        System.out.println(e + "\n\n");
                    }
                });
                break;
            default:
                System.out.println("Optiune necunoscuta!");
        }
    }

    public static void MeniulSistemelorDeOperare(){
        System.out.println("Windows");
        System.out.println("Linux");
    }

    public static void Setare_Sistem_De_Operare(List<Echipament>echipament){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Sistemul de calcul la care doriti sa setati un sistem de operare: ");
        String nume = scanner.nextLine();

        MeniulSistemelorDeOperare();
        Sisteme_De_Calcul.SistemDeOperare sistem_de_operare;

        System.out.println("Alege sistemul de operare: ");
        String so = scanner.next();
        sistem_de_operare = Sisteme_De_Calcul.SistemDeOperare.valueOf(so);

        switch (sistem_de_operare){
            case windows:
                echipament.forEach(e -> {
                    if (nume.equalsIgnoreCase(e.getDenumire()) && e instanceof Sisteme_De_Calcul){
                        ((Sisteme_De_Calcul)e).setSistemDeOperare(Sisteme_De_Calcul.SistemDeOperare.windows);

                        System.out.println("Actualizare: ");
                        System.out.println(e + "\n\n");
                    }
                });
                break;
            case linux:
                echipament.forEach(e -> {
                    if (nume.equalsIgnoreCase(e.getDenumire()) && e instanceof Sisteme_De_Calcul){
                        ((Sisteme_De_Calcul)e).setSistemDeOperare(Sisteme_De_Calcul.SistemDeOperare.linux);

                        System.out.println("Actualizare: ");
                        System.out.println(e + "\n\n");
                    }
                });
                break;
            default:
                System.out.println("Optiune necunoscuta!");
        }
    }

    public static void Afisare_Echipamente_Vandute(List<Echipament>echipament){
        for (Echipament e : echipament)
            if(e.getSituatie() == Echipament.Situatie.vandut)
                System.out.println(e + "\n\n");
    }

    public static void Afisare(List<Echipament>echipament){
        for (Echipament e : echipament)
            System.out.println(e + "\n\n");
    }

    public static void Afisare_Imprimante(List<Echipament>echipament){
        for (Echipament e : echipament)
            if(e instanceof Imprimante)
                System.out.println(e + "\n\n");
    }

    public static void Afisare_Copiatoare(List<Echipament>echipament){
        for (Echipament e : echipament)
            if(e instanceof Copiatoare)
                System.out.println(e + "\n\n");
    }

    public static void Afisare_Sisteme_De_Calcul(List<Echipament>echipament){
        for (Echipament e : echipament)
            if(e instanceof Sisteme_De_Calcul)
                System.out.println(e + "\n\n");
    }

    public static void main(String[] args) throws FileNotFoundException{
        List<Echipament>echipamente = new ArrayList<>();
        Meniu enunturi = new Meniu();
        Scanner scanner = new Scanner(System.in);
        Citire_Din_Fisier(echipamente);
        int opt;
        enunturi.meniu();
        opt = scanner.nextInt();

        while (opt > 0) {
            switch (opt){
                case 1:
                    Afisare(echipamente);
                    break;
                case 2:
                    Afisare_Imprimante(echipamente);
                    break;
                case 3:
                    Afisare_Copiatoare(echipamente);
                    break;
                case 4:
                    Afisare_Sisteme_De_Calcul(echipamente);
                    break;
                case 5:
                    Setare_Stare_Echipamente(echipamente);
                    break;
                case 6:
                    Setare_Mod_Tiparire(echipamente);
                    break;
                case 7:
                    Setare_Format_Copiatoare(echipamente);
                    break;
                case 8:
                    Setare_Sistem_De_Operare(echipamente);
                    break;
                case 9:
                    Afisare_Echipamente_Vandute(echipamente);
                    break;
                case 10:
                    break;
                default:
                    System.out.println("Optiune necunoscuta!");
            }
            enunturi.meniu();
            opt = scanner.nextInt();
        }
    }
}
