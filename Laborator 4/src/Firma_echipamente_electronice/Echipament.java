package Firma_echipamente_electronice;

public class Echipament
{
    private String denumire;
    private int nr_inv;
    private int pret;
    private Situatie situatie;
    private String zona_mag;

    public Echipament(){}

    public Echipament(String denumire, int nr_inv, int pret, String zona_mag, Situatie situatie)
    {
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.situatie = situatie;
    }

    public enum Situatie{
        achizitionat, expus, vandut
    }

    public void setSituatie(Situatie s){
        situatie = s;
    }

    public String getDenumire() {
        return denumire;
    }

    public Situatie getSituatie(){
        return situatie;
    }

    @Override
    public String toString() {
        return "Denumirea: " + denumire + ";\nNumar de inventar: " + nr_inv + ";\nPret: " + pret + ";\nZona magazin: " + zona_mag + ";\nEchipament aflat in situatia: " + situatie;
    }
}
