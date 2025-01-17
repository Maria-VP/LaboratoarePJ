package Angajati;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Angajat> angajati = new ArrayList<>();
        angajati.add(new Angajat("Ion Popescu", "Director", LocalDate.of(2022, 5, 10), 3000));
        angajati.add(new Angajat("Maria Ionescu", "Programator", LocalDate.of(2023, 6, 15), 2500));
        angajati.add(new Angajat("George Georgescu", "Sef departament", LocalDate.of(2021, 3, 20), 3500));

        int anCurent = LocalDate.now().getYear();

        Meniu meniu = new Meniu();
        meniu.AfisareMeniu();
        int opt = scanner.nextInt();

        while (opt > 0){
            switch (opt){
                case 1:
                    angajati.forEach(System.out::println);
                    break;
                case 2:
                    angajati.stream()
                            .filter(angajat -> angajat.getSalariul() > 2500)
                            .forEach(System.out::println);
                    break;
                case 3:
                    int anTrecut = anCurent - 1;
                    List<Angajat> angajatiConducereAprilie = angajati.stream()
                            .filter(angajat -> angajat.getDataAngajarii().getYear() == anTrecut)
                            .filter(angajat -> angajat.getDataAngajarii().getMonthValue() == 4)
                            .filter(angajat -> angajat.getPostul().toLowerCase().contains("sef") || angajat.getPostul().toLowerCase().contains("director"))
                            .collect(Collectors.toList());

                    if (angajatiConducereAprilie.isEmpty()) {
                        System.out.println("Nu sunt angajați în aprilie anul trecut cu funcție de conducere.");
                    } else {
                        angajatiConducereAprilie.forEach(System.out::println);
                    }
                    break;
                case 4:
                    angajati.stream()
                            .filter(angajat -> !(angajat.getPostul().toLowerCase().contains("sef") || angajat.getPostul().toLowerCase().contains("director")))
                            .sorted((a1, a2) -> Float.compare(a2.getSalariul(), a1.getSalariul()))
                            .forEach(System.out::println);

                    break;
                case 5:
                    List<String> numeMajuscule = angajati.stream()
                            .map(angajat -> angajat.getNume().toUpperCase())
                            .collect(Collectors.toList());

                    numeMajuscule.forEach(System.out::println);
                    break;
                case 6:
                    angajati.stream()
                            .map(Angajat::getSalariul)
                            .filter(salariu -> salariu < 3000)
                            .forEach(System.out::println);
                    break;
                case 7:
                    Optional<Angajat> primulAngajat = angajati.stream()
                            .min((a1, a2) -> a1.getDataAngajarii().compareTo(a2.getDataAngajarii()));

                    if (primulAngajat.isPresent()) {
                        System.out.println(primulAngajat.get());
                    } else {
                        System.out.println("Nu există angajați.");
                    }
                    break;
                case 8:
                    DoubleSummaryStatistics statistici = angajati.stream()
                            .collect(Collectors.summarizingDouble(Angajat::getSalariul));

                    System.out.println("Salariul mediu: " + statistici.getAverage());
                    System.out.println("Salariul minim: " + statistici.getMin());
                    System.out.println("Salariul maxim: " + statistici.getMax());
                    break;
                case 9:
                    Optional<Angajat> ionAngajat = angajati.stream()
                            .filter(angajat -> angajat.getNume().toLowerCase().contains("ion"))
                            .findAny();

                    ionAngajat.ifPresentOrElse(
                            angajat -> System.out.println("Firma are cel puțin un Ion angajat"),
                            () -> System.out.println("Firma nu are nici un Ion angajat")
                    );
                    break;
                case 10:
                    long numarAngajatiVara = angajati.stream()
                            .filter(angajat -> angajat.getDataAngajarii().getYear() == anCurent - 1)
                            .filter(angajat -> angajat.getDataAngajarii().getMonthValue() >= 6 && angajat.getDataAngajarii().getMonthValue() <= 8)
                            .count();

                    System.out.println("Numărul de angajați care s-au angajat în vara anului precedent: " + numarAngajatiVara);
                    break;
                default:
                    System.out.println("Optiune necunoscuta!");
                    break;
            }

            meniu.AfisareMeniu();
            opt = scanner.nextInt();
        }
    }
}
