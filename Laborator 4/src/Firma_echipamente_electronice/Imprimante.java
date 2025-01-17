package Firma_echipamente_electronice;

public class Imprimante extends Echipament
{
    private String rezolutie;
    private int ppm, p_car;
    private Mod_Tiparire mod_tiparire;

    public Imprimante(){}

    public Imprimante(String denumire, int nr_inv, int pret, String zona_mag, Situatie situatie, int ppm, String rezolutie, int p_car, Mod_Tiparire mod_tiparire){
        super(denumire, nr_inv, pret, zona_mag, situatie);
        this.ppm = ppm;
        this.p_car = p_car;
        this.rezolutie = rezolutie;
        this.mod_tiparire = mod_tiparire;
    }

    public enum Mod_Tiparire{
        alb_negru, color
    }

    public void setMod_Tiparire(Mod_Tiparire mt){
        this.mod_tiparire = mt;
    }

    @Override
    public String toString() {
        return super.toString() + ";\nNumarul de pagini scrise pe minut: " + ppm + ";\nNumar de pagini/cartus: " + p_car + ";\nRezolutie: " + rezolutie + ";\nMod tiparire: " + mod_tiparire;
    }
}
