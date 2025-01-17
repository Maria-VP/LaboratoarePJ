package Exercitiul2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void scriere(List<PerecheNumere>lista) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/main/resources/perechi.json");
        objectMapper.writeValue(file, lista);
    }

    public static List<PerecheNumere> citire() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/main/resources/perechi.json");
        List<PerecheNumere>lista = objectMapper.readValue(file, new TypeReference<List<PerecheNumere>>() {});
        return lista;
    }

    public static void suntConsec(List<PerecheNumere>lista){
        for (PerecheNumere pN : lista)
            if (pN.suntConsecutiveFibonacci())
                System.out.println("Sunt consecutive.");
            else
                System.out.println("Nu sunt consecutive.");
    }

    public static void cmmmc(List<PerecheNumere>lista){
        for (PerecheNumere pN : lista)
            System.out.println("Cel mai mic multiplu comun este: " + pN.celMicMultipluComun());
    }

    public static void auSumaCEgala(List<PerecheNumere>lista){
        for (PerecheNumere pN : lista)
            if (pN.auSumaCifrelorEgala())
                System.out.println("Au suma cifrelor egala.");
    }

    public static void auAcelasiNrDeCifrePare(List<PerecheNumere>lista){
        for (PerecheNumere pN : lista)
            if (pN.auAcelasiNumarCifrePare())
                System.out.println("Au acelasi numar de cifre pare.");
    }

    public static void main(String[] args) throws IOException {
        List<PerecheNumere>lista_perechi = new ArrayList<>();
        scriere(lista_perechi);
        suntConsec(lista_perechi);
        cmmmc(lista_perechi);
        auSumaCEgala(lista_perechi);
        auAcelasiNrDeCifrePare(lista_perechi);
    }
}
