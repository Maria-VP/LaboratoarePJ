package Firma_echipamente_electronice;

public class CreareCopiator {
    public Copiatoare Creare_Copiator(String[] linie){
        String denumire, zona_mag;
        Echipament.Situatie situatie;
        int nr_inv, pret, p_ton;
        Copiatoare.Format format;

        denumire = linie[0];
        nr_inv = Integer.parseInt(linie[1]);
        pret = Integer.parseInt(linie[2]);
        zona_mag = linie[3];
        situatie = Echipament.Situatie.valueOf(linie[4]);
        p_ton = Integer.parseInt(linie[6]);
        format = Copiatoare.Format.valueOf(linie[7]);

        return new Copiatoare(denumire, nr_inv, pret, zona_mag, situatie, p_ton, format);
    }
}
