package Exercitiul3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Placa {
    private String descriere;
    private int lungime;
    private int latime;
    private String orientare;
    private boolean[] canturi;
    private int nr_bucati;

    public String getDescriere() {
        return descriere;
    }
    public int getLungime() {
        return lungime;
    }
    public int getLatime() {
        return latime;
    }
    public String getOrientare() {
        return orientare;
    }
    public boolean[] getCanturi() {
        return canturi;
    }
    public int getNrBucati() {
        return nr_bucati;
    }

    @Override
    public String toString() {
        return "Placa {" + "\n" + "descriere = " + descriere + "\n" + "lungime = " + lungime + "\n" + "latime = " + latime + "\n" + "nr_bucati = " + nr_bucati + "\n" + "}\n\n";
    }
}
