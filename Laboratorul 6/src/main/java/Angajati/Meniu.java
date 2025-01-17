package Angajati;

public class Meniu {
    public void AfisareMeniu(){
        System.out.println("1. Afișarea listei de angajați folosind referințe la metode.");
        System.out.println("2. Afișarea angajaților care au salariul peste 2500 RON");
        System.out.println("3. Crearea unei liste cu angajații din luna aprilie, a anului trecut, care au funcție de conducere (postul conține unul din cuvintele sef sau director).");
        System.out.println("4. Afișarea angajaților care nu au funcție de conducere (postul lor nu conține cuvintele director sau șef), în ordine descrescătoare a salariilor.");
        System.out.println("5. Extragerea din lista de angajați a unei liste de String-uri care conține numele angajaților scrise cu majuscule.");
        System.out.println("6. Afișarea salariilor mai mici de 3000 de RON (doar salariile, fără alte informații) folosind stream-uri, expresii lambda, referințe la metode şi metoda map(). ");
        System.out.println("7. Afișarea datelor primului angajat al firmei. ");
        System.out.println("8. Afișarea de statistici referitoare la salariul angajaților.");
        System.out.println("9. Afișarea unor mesaje care indică dacă printre angajați există cel puțin un “Ion”.");
        System.out.println("10. Afișarea numărului de persoane care s-au angajat în vara anului precedent.");
        System.out.println("0.Iesire.");
        System.out.println("Optiunea: ");
    }
}
