package laborator9.ex2.laborator9.ex2;

@Data
@Table("masini")
public class Masina {
    @Id
    private String numarInmatriculare;
    private String marca;
    private int anulFabricatiei;
    private String culoare;
    private int km;
}
