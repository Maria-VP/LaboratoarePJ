package Exercitiul1;

public class Carte {
    private String titlul, autorul;
    private int anulAparitiei;

    public String getTitlu() {
        return titlul;
    }

    public String getAutor() {
        return autorul;
    }

    public int getAnulAparitiei() {
        return anulAparitiei;
    }

    public void setAutorul(String autorul) {
        this.autorul = autorul;
    }

    public void setTitlul(String titlul) {
        this.titlul = titlul;
    }

    public void setAnulAparitiei(int anulAparitiei) {
        this.anulAparitiei = anulAparitiei;
    }

    public Carte(String titlul, String autorul, int anulAparitiei)
    {
        this.titlul = titlul;
        this.autorul = autorul;
        this.anulAparitiei = anulAparitiei;
    }
}
