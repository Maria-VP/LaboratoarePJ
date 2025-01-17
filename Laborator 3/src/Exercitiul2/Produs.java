package Exercitiul2;

import java.time.LocalDate;

public class Produs {
    private String nume;
    private float pret;
    private int cantitate;
    private LocalDate dataExpirarii;
    private static float incasari = 0;

    public Produs(String nume, float pret, int cantitate, LocalDate dataExpirarii) {
        this.nume = nume;
        this.pret = pret;
        this.cantitate = cantitate;
        this.dataExpirarii = dataExpirarii;
    }

    public String getNume() {
        return nume;
    }
    public double getPret() {
        return pret;
    }
    public int getCantitate() {
        return cantitate;
    }
    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }
    public LocalDate getDataExpirarii() {
        return dataExpirarii;
    }

    public static void adaugaIncasari(float suma) {
        incasari += suma;
    }

    @Override
    public String toString() {
        return nume + ", " + pret + ", " + cantitate + ", " + dataExpirarii;
    }
}
