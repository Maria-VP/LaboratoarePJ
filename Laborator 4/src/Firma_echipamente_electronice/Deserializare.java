package Firma_echipamente_electronice;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Deserializare {
    public List<Echipament> deserializareEchipamente(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Echipament>) ois.readObject(); // Citim lista din fișier
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Eroare la deserializare: " + e.getMessage());
            return null;
        }
    }
}
