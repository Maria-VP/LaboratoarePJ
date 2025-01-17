package Exercitiul4;

/*
Se va crea clasa Persoana cu variabile membre private nume (String) şi cnp (String).
Clasa va avea constructor cu parametri, gettere si settere în funcție de necesități şi metoda
getVarsta() care va calcula şi va returna vârsta persoanei extrăgând data nașterii din CNP şi
citind din sistem data curentă. Se va utiliza clasa LocalDate. Se va crea un vector în care se
vor adăuga obiectele de tip Persoana. Fiecare element din vectorul va fi afișat pe un rând în
formatul nume, CNP, varsta.
 */

import java.time.LocalDate;

public class Persoana {
    private String nume;
    private String cnp;
    private int Varsta;

    public Persoana(String nume, String cnp, int Varsta) {
        this.nume = nume;
        this.cnp = cnp;
        this.Varsta = Varsta;
    }

    public String getNume() {
        return nume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public int getVarsta() {
        return Varsta;
    }

    public void setVarsta(int varsta) {
        Varsta = varsta;
    }
}
