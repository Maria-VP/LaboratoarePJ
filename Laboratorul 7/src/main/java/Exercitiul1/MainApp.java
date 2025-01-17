package Exercitiul1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MainApp {

    public static Map<Integer, Carte> citesteCarti(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        File file = new File(fileName);
        if (file.exists()) {
            return mapper.readValue(file, mapper.getTypeFactory().constructMapType(HashMap.class, Integer.class, Carte.class));
        } else {
            return new HashMap<>();
        }
    }

    public static void salveazaCarti(Map<Integer, Carte> carti, String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(fileName), carti);
    }

    record Carte(
            @JsonProperty("autor") String autorul,
            @JsonProperty("titlu") String titlul,
            @JsonProperty("anulAparitiei") int anulAparitiei
    ) {}

    public static void afiseazaCarti(Map<Integer, Carte> carti) {
        carti.forEach((id, carte) -> System.out.println("ID: " + id + ", " + carte));
    }

    public static void stergeCarti(Map<Integer, Carte> carti, int id) {
        carti.remove(id);
    }

    public static void adaugareCarte(Map<Integer, Carte> carti, int id, Carte carte) {
        carti.putIfAbsent(id, carte);
    }

    public static Set<Carte> getCartiByAutor(Map<Integer, Carte> carti, String autor) {
        return carti.values().stream()
                .filter(carte -> autor.equals(carte.autorul()))
                .collect(Collectors.toSet());
    }

    public static void sortareCartiDupaTitlu(Set<Carte> carti) {
        carti.stream()
                .sorted(Comparator.comparing(Carte::titlul))
                .forEach(System.out::println);
    }

    public static void afiseazaCeaMaiVecheCarte(Set<Carte> carti) {
        Optional<Carte> ceaMaiVecheCarte = carti.stream()
                .min(Comparator.comparingInt(Carte::anulAparitiei));

        ceaMaiVecheCarte.ifPresentOrElse(
                carte -> System.out.println("\nCea mai veche carte: " + carte),
                () -> System.out.println("\nNu există cărți.")
        );
    }

    public static void main(String[] args) throws IOException {
        Map<Integer, Carte> carti = citesteCarti("carti.json");

        System.out.println("Colecția de cărți:");
        afiseazaCarti(carti);

        stergeCarti(carti, 2);
        System.out.println("\nDupă ștergerea cărții cu ID-ul 2:");
        afiseazaCarti(carti);

        Carte carteNoua = new Carte("21 Lessons for the 21st Century", "Yuval Noah Harari", 2018);
        adaugareCarte(carti, 4, carteNoua);
        System.out.println("\nDupă adăugarea cărții noi:");
        afiseazaCarti(carti);

        salveazaCarti(carti, "carti.json");

        Set<Carte> cartiHarari = getCartiByAutor(carti, "Yuval Noah Harari");
        System.out.println("\nCărțile lui Yuval Noah Harari:");
        cartiHarari.forEach(System.out::println);

        System.out.println("\nCărțile ordonate după titlu:");
        sortareCartiDupaTitlu(cartiHarari);

        afiseazaCeaMaiVecheCarte(cartiHarari);
    }
}