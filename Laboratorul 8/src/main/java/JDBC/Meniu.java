package JDBC;

public class Meniu {
    public void AfisareMeniu(){
        System.out.println("1. Adauga o persoana în tabela persoane.");
        System.out.println("2. Adauga o excursie în tabela excursii.");
        System.out.println("3. Afișarea tuturor persoanelor şi pentru fiecare persoană afiseaza excursiile în care a fost.");
        System.out.println("4. Afișarea excursiilor în care a fost o persoană.");
        System.out.println("5. Afișarea tuturor persoanelor care au vizitat o anumita destinație.");
        System.out.println("6. Afișarea persoanelor care au făcut excursii într-un an introdus.");
        System.out.println("7. Șterge o excursie");
        System.out.println("8. Șterge o persoana (împreună cu excursiile în care a fost)");
        System.out.println("0. Iesire.");
        System.out.print("Optiunea: ");
    }
}
