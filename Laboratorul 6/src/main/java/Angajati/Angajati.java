package Angajati;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.time.LocalDate;

class Angajat {
    private String nume;
    private String postul;
    private LocalDate dataAngajarii;
    private float salariul;

    public Angajat(String nume, String postul, LocalDate dataAngajarii, float salariul) {
        this.nume = nume;
        this.postul = postul;
        this.dataAngajarii = dataAngajarii;
        this.salariul = salariul;
    }

    public Angajat() {}

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPostul() {
        return postul;
    }

    public void setPostul(String postul) {
        this.postul = postul;
    }

    public LocalDate getDataAngajarii() {
        return dataAngajarii;
    }

    public void setDataAngajarii(LocalDate dataAngajarii) {
        this.dataAngajarii = dataAngajarii;
    }

    public float getSalariul() {
        return salariul;
    }

    public void setSalariul(float salariul) {
        this.salariul = salariul;
    }

    public static void scriereInJSON(Angajat angajat) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            String json = mapper.writeValueAsString(angajat);
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return nume + "," + postul + "," + dataAngajarii + "," + salariul;
    }
}
