package lab9.lab9;

import org.springframework.beans.factory.annotation.Autowired;

public class MasinaService {
    @Autowired
    private MasinaRepository masinaRepository;

    public Masina adaugaMasina(Masina masina) {
        return masinaRepository.save(masina);
    }

    public void stergeMasina(String numarInmatriculare) {
        masinaRepository.deleteById(numarInmatriculare);
    }

    public Masina cautaMasina(String numarInmatriculare) {
        return masinaRepository.findById(numarInmatriculare).orElse(null);
    }

    public List<Masina> obtineToateMasinile() {
        return (List<Masina>) masinaRepository.findAll();
    }

    public long numarMasiniDupaMarca(String marca) {
        return masinaRepository.findByMarca(marca).size();
    }

    public long numarMasiniSub100000Km() {
        return masinaRepository.findByKmLessThan(100000).size();
    }

    public List<Masina> masiniMaiNoiDe5Ani() {
        int anulCurent = java.time.Year.now().getValue();
        return masinaRepository.findByAnulFabricatieiGreaterThan(anulCurent - 5);
    }
}
