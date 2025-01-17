package Firma_echipamente_electronice;

public class CreareImprimanta {
    public Imprimante Creare_Imprimanta(String[] linie){
        String denumire, zona_mag, rezolutie;
        int nr_inv, pret;
        Echipament.Situatie situatie;
        int ppm, p_car;
        Imprimante.Mod_Tiparire mod_tiparire;

        denumire = linie[0];
        nr_inv = Integer.parseInt(linie[1]);
        pret = Integer.parseInt(linie[2]);
        zona_mag = linie[3];
        situatie = Echipament.Situatie.valueOf(linie[4].toLowerCase());
        ppm = Integer.parseInt(linie[6]);
        rezolutie = linie[7];
        p_car = Integer.parseInt(linie[8]);
        mod_tiparire = Imprimante.Mod_Tiparire.valueOf(linie[9].toLowerCase());

        return new Imprimante(denumire, nr_inv, pret, zona_mag, situatie, ppm, rezolutie, p_car, mod_tiparire);
    }
}
