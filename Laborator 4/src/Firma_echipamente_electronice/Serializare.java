package Firma_echipamente_electronice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class Serializare {
     public void serializeazaEchipamente(List<Echipament> echipamente, String fileName) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                oos.writeObject(echipamente); // Scriem lista de echipamente în fișier
                System.out.println("Echipamentele au fost salvate în fișierul " + fileName);
            } catch (IOException e) {
                System.err.println("Eroare la serializare: " + e.getMessage());
            }
    }

}
