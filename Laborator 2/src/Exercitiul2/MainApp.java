package Exercitiul2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class MainApp {
    public static void main(String[] args) throws FileNotFoundException {
        Vers[] arr = new Vers[100];
        String vers;
        Scanner scanner = new Scanner(new File("src/Exercitiul2/cantec_in.txt"));
        PrintWriter printWriter = new PrintWriter("cantec_out.txt");
        int i = 0;
        while (scanner.hasNextLine())
        {
            vers = scanner.nextLine();
            arr[i] = new Vers(vers);
            printWriter.print(arr[i].getVersul() + "      ");
            printWriter.print(arr[i].numarVocale() + "    ");
            printWriter.print(arr[i].grupare() + "    ");
            printWriter.println(arr[i].generareNumar());
            i++;
        }
        printWriter.close();
    }
}