package Exercitiul2;

import java.util.Objects;

enum TipTobe {
    ELECTRONICE, ACUSTICE
}

public class SetTobe extends InstrumentMuzical{
    private TipTobe tip_tobe;
    private int nr_tobe;
    private int nr_cinele;

    public SetTobe(String producator, double pret, TipTobe tip_tobe, int nr_tobe, int nr_cinele) {
        super(producator, pret);
        this.tip_tobe = tip_tobe;
        this.nr_tobe = nr_tobe;
        this.nr_cinele = nr_cinele;
    }

    public TipTobe getTipTobe() {
        return tip_tobe;
    }

    public int getNrTobe() {
        return nr_tobe;
    }

    public int getNrCinele() {
        return nr_cinele;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tip Tobe: " + tip_tobe + ", Nr. Tobe: " + nr_tobe + ", Nr. Cinele: " + nr_cinele;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetTobe setTobe = (SetTobe) o;
        return nr_tobe == setTobe.nr_tobe && nr_cinele == setTobe.nr_cinele && Objects.equals(producator, setTobe.producator) && tip_tobe == setTobe.tip_tobe;
    }

    @Override
    public int hashCode() {
        return Objects.hash(producator, tip_tobe, nr_tobe, nr_cinele);
    }
}
