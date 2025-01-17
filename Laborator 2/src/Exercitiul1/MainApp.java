package Exercitiul1;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class MainApp {
    public static void Afisare(String[] arr)
    {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        String[] arr = new String[42];
        try{
            Scanner scanner = new Scanner(new File("src/Exercitiul1/judete_in.txt"));
            int i = 0;
            while (scanner.hasNextLine()) {
                arr[i] = scanner.next();
                System.out.print(arr[i] + " ");
                i++;
            }
            System.out.println();
            Arrays.sort(arr);
            Afisare(arr);
            Scanner scanner1 = new Scanner(System.in);
            System.out.print("\nIntroduceti un nume: ");
            String nume = scanner1.next(); int pozitie;
            pozitie = Arrays.binarySearch(arr, nume);
            System.out.println(pozitie);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Fisierul nu s-a putut deschide");
            e.printStackTrace();
        }
    }
}
