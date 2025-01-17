package Exercitiul2;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class MainApp {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Set<InstrumentMuzical> instrumente = new HashSet<>();

        instrumente.add(new Chitara("Fender", 2500, TipChitara.ELECTRICA, 6));
        instrumente.add(new Chitara("Gibson", 3000, TipChitara.ACUSTICA, 6));
        instrumente.add(new Chitara("Yamaha", 1500, TipChitara.CLASICA, 6));

        instrumente.add(new SetTobe("Pearl", 4500, TipTobe.ELECTRONICE, 5, 3));
        instrumente.add(new SetTobe("Tama", 3500, TipTobe.ACUSTICE, 5, 2));
        instrumente.add(new SetTobe("Roland", 4000, TipTobe.ELECTRONICE, 6, 4));
        ObjectMapper mapper = new ObjectMapper();
        mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
        mapper.writeValue(new File("src/main/resources/instrumente.json"), instrumente);

        Meniu meniu = new Meniu();
        meniu.AfisareMeniu();
        int opt = scanner.nextInt();

        while (opt > 0){
            switch (opt){
                case 1:
                    System.out.println("Introduse cu succes!");
                    break;
                case 2:
                    System.out.println("Salvata cu succes!");
                    break;
                case 3:
                    mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL);
                    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

                    mapper.getTypeFactory().constructCollectionType(Set.class, InstrumentMuzical.class);

                    instrumente.forEach(System.out::println);
                    break;
                case 5:
                    Chitara chitaraNoua = new Chitara("Fender", 2500, TipChitara.ELECTRICA, 6);
                    if (!instrumente.add(chitaraNoua)) {
                        System.out.println("Instrumentul deja există în colecție.");
                    } else {
                        System.out.println("Instrumentul a fost adăugat.");
                    }
                    break;
                case 6:
                    instrumente.removeIf(instrument -> instrument.getPret() > 3000);
                    System.out.println("Instrumentele rămase după eliminarea celor cu preț > 3000:");
                    instrumente.forEach(System.out::println);
                    break;
                case 7:
                    instrumente.stream()
                            .filter(instrument -> instrument instanceof Chitara)
                            .forEach(System.out::println);
                    break;
                case 8:
                    instrumente.stream()
                            .filter(instrument -> instrument.getClass() == SetTobe.class)
                            .forEach(System.out::println);
                    break;
                case 9:
                    instrumente.stream()
                            .filter(instrument -> instrument instanceof Chitara)
                            .map(instrument -> (Chitara) instrument)
                            .max((chitara1, chitara2) -> Integer.compare(chitara1.getNrCorzi(), chitara2.getNrCorzi()))
                            .ifPresent(System.out::println);
                    break;
                case 10:
                    instrumente.stream()
                            .filter(instrument -> instrument instanceof SetTobe)
                            .map(instrument -> (SetTobe) instrument)
                            .filter(setTobe -> setTobe.getTipTobe() == TipTobe.ACUSTICE)
                            .sorted((set1, set2) -> Integer.compare(set1.getNrTobe(), set2.getNrTobe()))
                            .forEach(System.out::println);
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
