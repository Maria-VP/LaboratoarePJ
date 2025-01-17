package Exercitiul1;

public class Parabola {
    private int a, b, c;

    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public void afiseazaVarf() {
        int xVarf = -b / (2 * a);
        int yVarf = (-b * b + 4 * a * c) / (4 * a);
        System.out.println("Varf: (" + xVarf + ", " + yVarf + ")");
    }

    public void afiseazaMijlocSiDistanta(Parabola p) {
        int xVarf1 = -b / (2 * a);
        int yVarf1 = (-b * b + 4 * a * c) / (4 * a);

        int xVarf2 = -p.b / (2 * p.a);
        int yVarf2 = (-p.b * p.b + 4 * p.a * p.c) / (4 * p.a);

        int xMijloc = (xVarf1 + xVarf2) / 2;
        int yMijloc = (yVarf1 + yVarf2) / 2;

        int distanta = (int) Math.sqrt((xVarf2 - xVarf1) * (xVarf2 - xVarf1) + (yVarf2 - yVarf1) * (yVarf2 - yVarf1));

        System.out.println("Mijloc segment: (" + xMijloc + ", " + yMijloc + ")");
        System.out.println("Distanta intre varfuri: " + distanta);
    }
}
