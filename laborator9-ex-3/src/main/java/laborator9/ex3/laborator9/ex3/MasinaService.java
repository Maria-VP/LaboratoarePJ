package laborator9.ex3.laborator9.ex3;

public class MasinaService {
    @Autowired
    private MasinaRepository masinaRepository;

    public Masina adaugaMasina(Masina masina) {
        return masinaRepository.save(masina);
    }

    public void stergeMasina(String numarInmatriculare) {
        masinaRepository.deleteById(numarInmatriculare);
    }

    public Optional<Masina> cautaMasina(String numarInmatriculare) {
        return masinaRepository.findById(numarInmatriculare);
    }

    public List<Masina> obtineToateMasinile() {
        return (List<Masina>) masinaRepository.findAll();
    }

    public List<Masina> masiniMarca(String marca) {
        return masinaRepository.findByMarca(marca);
    }

    public int masiniSub100kKm() {
        return masinaRepository.countByKmLessThan100000();
    }

    public List<Masina> masiniNoi() {
        return masinaRepository.findMasiniNoi();
    }
}
