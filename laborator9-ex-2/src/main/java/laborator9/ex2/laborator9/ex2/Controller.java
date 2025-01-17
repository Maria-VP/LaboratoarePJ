package laborator9.ex2.laborator9.ex2;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/masini")
public class MasinaController {
    @Autowired
    private MasinaService masinaService;

    @PostMapping
    public Masina adaugaMasina(@RequestBody Masina masina) {
        return masinaService.adaugaMasina(masina);
    }

    @DeleteMapping("/{numarInmatriculare}")
    public void stergeMasina(@PathVariable String numarInmatriculare) {
        masinaService.stergeMasina(numarInmatriculare);
    }

    @GetMapping("/{numarInmatriculare}")
    public Optional<Masina> cautaMasina(@PathVariable String numarInmatriculare) {
        return masinaService.cautaMasina(numarInmatriculare);
    }

    @GetMapping
    public List<Masina> obtineToateMasinile() {
        return masinaService.obtineToateMasinile();
    }

    @GetMapping("/marca/{marca}")
    public List<Masina> masiniMarca(@PathVariable String marca) {
        return masinaService.masiniMarca(marca);
    }

    @GetMapping("/sub100kKm")
    public List<Masina> masiniSub100kKm() {
        return masinaService.masiniSub100kKm();
    }

    @GetMapping("/noi")
    public List<Masina> masiniNoi() {
        return masinaService.masiniNoi();
    }
}
