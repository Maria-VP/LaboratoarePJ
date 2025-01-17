package Exercitiul2;

import java.io.*;
import java.util.Scanner;

public class Fisiere
{
    public static void main(String[] args)
    {
        try
        {
            Scanner scanner = new Scanner(new File("src/Tema2/Set_Numere.txt"));
            float sum = 0, counter = 0;
            int Max=Integer.MIN_VALUE, Min = Integer.MAX_VALUE;
            while(scanner.hasNext())
            {
                int number = Integer.parseInt(scanner.nextLine());
                sum=sum+number;
                if(Max<=number)
                    Max=number;
                if(Min>number)
                    Min=number;
                counter++;
            }
            float averrage = (float) sum/counter;
            System.out.println("Suma: " + sum);
            System.out.println("Numarul de numere: " + counter);
            System.out.println("Numarul maxim: " + Max);
            System.out.println("Numarul minim: " + Min);
            System.out.println("Media: " + averrage);
            try
            {
                PrintWriter flux_out = new PrintWriter("src/Tema2/Afisare.txt");
                flux_out.println("Suma elementelor date este: " + sum);
                flux_out.println("Media aritmetica a elementelor date este: " + averrage);
                flux_out.println("Valoarea maxima a numerelor date este: " + Max);
                flux_out.println("Valoarea minima a numerelor date este: " + Min);
                flux_out.close();
            }
            catch (FileNotFoundException e)
            {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
}