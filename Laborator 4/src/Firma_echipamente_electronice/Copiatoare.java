package Firma_echipamente_electronice;

public class Copiatoare extends Echipament
{
    private int p_ton;
    private Format format;

    public Copiatoare(){}

    public Copiatoare(String denumire, int nr_inv, int pret, String zona_mag, Situatie situatie, int p_ton, Format format){
        super(denumire, nr_inv, pret, zona_mag, situatie);
        this.p_ton = p_ton;
        this.format = format;
    }

    public enum Format{
        A3, A4
    }

    public void setFormat(Format f){
        format = f;
    }

    public Format getFormat(){
        return format;
    }

    @Override
    public String toString() {
        return super.toString() + "\nNumar de pagini/toner: " + p_ton + ";\nFormat: " + format;
    }
}
