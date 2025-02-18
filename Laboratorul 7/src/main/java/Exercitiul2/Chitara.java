package Exercitiul2;

import java.util.Objects;

enum TipChitara {
    ELECTRICA, ACUSTICA, CLASICA
}

public class Chitara extends InstrumentMuzical{
    private TipChitara tip_chitara;
    private int nr_corzi;

    public Chitara(String producator, double pret, TipChitara tip_chitara, int nr_corzi) {
        super(producator, pret);
        this.tip_chitara = tip_chitara;
        this.nr_corzi = nr_corzi;
    }

    public TipChitara getTipChitara() {
        return tip_chitara;
    }

    public int getNrCorzi() {
        return nr_corzi;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tip Chitara: " + tip_chitara + ", Nr. Corzi: " + nr_corzi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chitara chitara = (Chitara) o;
        return nr_corzi == chitara.nr_corzi && Objects.equals(producator, chitara.producator) && tip_chitara == chitara.tip_chitara;
    }

    @Override
    public int hashCode() {
        return Objects.hash(producator, tip_chitara, nr_corzi);
    }
}
