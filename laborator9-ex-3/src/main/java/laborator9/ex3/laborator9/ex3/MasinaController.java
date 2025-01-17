package laborator9.ex3.laborator9.ex3;

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
    public int masiniSub100kKm() {
        return masinaService.masiniSub100kKm();
    }

    @GetMapping("/noi")
    public List<Masina> masiniNoi() {
        return masinaService.masiniNoi();
    }
}
