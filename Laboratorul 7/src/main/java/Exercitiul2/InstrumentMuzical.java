package Exercitiul2;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Chitara.class, name = "chitara"),
        @JsonSubTypes.Type(value = SetTobe.class, name = "settobe")
})
abstract class InstrumentMuzical {
    protected String producator;
    protected double pret;

    public InstrumentMuzical(String producator, double pret) {
        this.producator = producator;
        this.pret = pret;
    }

    public String getProducator() {
        return producator;
    }

    public double getPret() {
        return pret;
    }

    @Override
    public String toString() {
        return "Producator: " + producator + ", Pret: " + pret;
    }
}
