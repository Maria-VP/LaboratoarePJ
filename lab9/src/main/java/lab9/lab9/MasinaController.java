package lab9.lab9;

import org.springframework.beans.factory.annotation.Autowired;

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
    public Masina cautaMasina(@PathVariable String numarInmatriculare) {
        return masinaService.cautaMasina(numarInmatriculare);
    }

    @GetMapping
    public List<Masina> obtineToateMasinile() {
        return masinaService.obtineToateMasinile();
}
