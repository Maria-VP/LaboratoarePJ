package Exercitiul3;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainApp {
    public static List<Mobilier> citireMobilier() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File("src/main/resources/mobilier.json"), new TypeReference<List<Mobilier>>() {});
    }

    public static void main(String[] args) {
        try {
            List<Mobilier> mobilierList = citireMobilier();
            mobilierList.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
