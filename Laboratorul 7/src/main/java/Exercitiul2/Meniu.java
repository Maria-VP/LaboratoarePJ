package Exercitiul2;

public class Meniu {
    public void AfisareMeniu(){
        System.out.println("1.Creează o colecție de tip Set<InstrumentMuzical> în care utilizând polimorfismul se introduc 3 chitări şi 3 seturi de tobe");
        System.out.println("2.Salvează colecția Set<InstrumentMuzical> în fișierul instrumente.json. ");
        System.out.println("3.Încarcă datele din fişierul instrumente.json în program, într-o colecție de tip Set<InstrumentMuzical>");
        System.out.println("4.Să se afișeze implementarea utilizată pentru interfața Set de către ObjectMapper în urma citirii ");
        System.out.println("5.Să se verifice dacă colecția Set permite sau nu duplicate");
        System.out.println("6. Să se șteargă instrumentele din Set al căror preț este mai mare de 3000 de RON.");
        System.out.println("7. Să se afișeze toate datele chitărilor, utilizând Stream API şi operatorul instanceof");
        System.out.println("8.Să se afișeze toate datele tobelor, utilizând Stream API şi metoda getClass()");
        System.out.println("9.Să se afișeze datele chitării care are cele mai multe corzi, utilizând Stream API,expresii Lambda, referințe la metode şi clasa Optional.");
        System.out.println("10.Să se afișeze datele tobelor acustice, ordonat după numărul de tobe din set utilizând Stream API, referințe la metode, expresii Lambda, etc");
        System.out.println("0.Iesire.");
        System.out.println("Optiunea: ");
    }
}
