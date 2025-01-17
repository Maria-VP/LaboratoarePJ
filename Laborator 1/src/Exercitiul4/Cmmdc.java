package Exercitiul4;

public class Cmmdc {
    public int aflareCmmdc(int a, int b)
    {
        while (a != b)
            if (a > b)
                a = a - b;
            else
                b = b - a;

        return  a;
    }
}
