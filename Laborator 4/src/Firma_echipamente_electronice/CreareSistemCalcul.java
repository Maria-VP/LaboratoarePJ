package Firma_echipamente_electronice;

public class CreareSistemCalcul {
    public Sisteme_De_Calcul Creare_Sistem_De_Calcul(String[] linie){
        String denumire, zona_mag, tip_mon;
        Echipament.Situatie situatie;
        int nr_inv, pret, c_hdd;
        float vit_proc;
        Sisteme_De_Calcul.SistemDeOperare sisteme_de_operare;

        denumire = linie[0];
        nr_inv = Integer.parseInt(linie[1]);
        pret = Integer.parseInt(linie[2]);
        zona_mag = linie[3];
        situatie = Echipament.Situatie.valueOf(linie[4]);
        tip_mon = linie[6];
        vit_proc = Float.parseFloat(linie[7]);
        c_hdd = Integer.parseInt(linie[8]);
        sisteme_de_operare = Sisteme_De_Calcul.SistemDeOperare.valueOf(linie[9].toLowerCase());

        return new Sisteme_De_Calcul(denumire, nr_inv, pret, zona_mag, situatie, tip_mon, vit_proc, c_hdd, sisteme_de_operare);
    }
}
