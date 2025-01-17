package Exercitiul3;

public class Divizori {
    public int nrPrim(int numar)
    {
        if (numar < 2)
            return 2;

        for (int divizor = 2; divizor <= numar/2; divizor++)
            if (numar % divizor == 0)
                return 1;

        return 0;
    }
    public void afisareDivizori(int nr) {
        System.out.print("Divizorii sunt: ");
        for (int divizor = 2; divizor <= nr / 2; divizor++)
            if (nr % divizor == 0) {
                System.out.print(divizor + " ");
            }
    }
}
