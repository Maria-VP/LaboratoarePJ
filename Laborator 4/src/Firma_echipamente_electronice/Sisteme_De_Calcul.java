package Firma_echipamente_electronice;

public class Sisteme_De_Calcul extends Echipament {
    private String tip_mon;
    private int c_hdd;
    private float vit_proc;
    private SistemDeOperare sisteme_de_operare;

    public Sisteme_De_Calcul(String denumire, int nr_inv, int pret, String zona_mag, Situatie situatie, String tip_mon, float vit_proc, int c_hdd, SistemDeOperare sisteme_de_operare){
        super(denumire, nr_inv, pret, zona_mag, situatie);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.sisteme_de_operare = sisteme_de_operare;
    }

    public enum SistemDeOperare{
        windows, linux
    }

    public void setSistemDeOperare(SistemDeOperare s){
        sisteme_de_operare = s;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTip monitor: " + tip_mon + ";\nViteza procesor: " + vit_proc + ";\nCapacitate a HDD: " + c_hdd + ";\nSistem de operare: " + sisteme_de_operare;
    }
}
