package laborator9.ex2.laborator9.ex2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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

    public List<Masina> masiniSub100kKm() {
        return masinaRepository.findByKmLessThan100000();
    }

    public List<Masina> masiniNoi() {
        return masinaRepository.findMasiniNoi();
    }
}
