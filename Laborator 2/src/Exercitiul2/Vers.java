package Exercitiul2;

import java.util.Random;

public class Vers {
    private String versul;
    public Vers(String versul){
        this.versul = versul;
    }
    public int eVocala(char caracter)
    {
        if (caracter == 'a' || caracter == 'A')
            return 1;
        else if (caracter == 'e' || caracter == 'E')
            return 1;
        else if (caracter == 'i' || caracter == 'I')
            return 1;
        else if (caracter == 'o' || caracter == 'O')
            return 1;
        else if (caracter == 'u' || caracter == 'U')
            return 1;
        else
            return 0;
    }

    public int eGrupare(String grupare)
    {
        if (grupare.equals("che") || grupare.equals("Che"))
            return 1;
        else if (grupare.equals("chi") || grupare.equals("Chi"))
            return 1;
        else if (grupare.equals("ghe") || grupare.equals("Ghe"))
            return 1;
        else if (grupare.equals("ghi") || grupare.equals("Ghi"))
            return 1;
        else if (grupare.equals("ge") || grupare.equals("Ge"))
            return 1;
        else if (grupare.equals("gi") || grupare.equals("Gi"))
            return 1;
        else if (grupare.equals("ce") || grupare.equals("Ce"))
            return 1;
        else if (grupare.equals("ci") || grupare.equals("Ci"))
            return 1;
        else
            return 0;
    }

    public int numarVocale()
    {
        int counter = 0;
        for (int i = 0; i < versul.length(); i++) {
            char litera = versul.charAt(i);
            if (eVocala(litera) == 1)
                counter++;
        }

        return counter;
    }

    public String grupare() throws IndexOutOfBoundsException
    {
        int primaPozitie = versul.length()-3;
        int ultimaPozitie = versul.length();
        if(eGrupare(versul.substring(primaPozitie, ultimaPozitie)) == 1 )
            return "*";
        else if(eGrupare(versul.substring(versul.length()-2, ultimaPozitie)) == 1)
            return "*";
        return " ";
    }

    public String generareNumar()
    {
        Random random = new Random();
        int nr_generat = random.nextInt(2);
        System.out.println(nr_generat);
        if(nr_generat < 0.1)
            return versul.toUpperCase();
        return " ";
    }
    public String getVersul()
    {
        return versul;
    }
}
