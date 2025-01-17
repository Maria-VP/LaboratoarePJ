package laborator11.laborator11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/jpa/evenimente")
public class EvenimentController {

    @Autowired
    private EvenimentRepository evenimentRepository;

    @GetMapping
    public List<Eveniment> getAllEvenimente() {
        return evenimentRepository.findAll();
    }

    @GetMapping("/locatie/{denumire_locatie}")
    public List<Eveniment> getEvenimenteByLocatie(@PathVariable String denumire_locatie) {
        return evenimentRepository.findByLocatie(denumire_locatie);
    }

    @GetMapping("/data/{data_eveniment}")
    public List<Eveniment> getEvenimenteByData(@PathVariable String data_eveniment) {
        LocalDate date = LocalDate.parse(data_eveniment);
        return evenimentRepository.findByData(date);
    }

    @PostMapping
    public Eveniment createEveniment(@RequestBody Eveniment eveniment) {
        return evenimentRepository.save(eveniment);
    }

    @PutMapping
    public Eveniment updateEveniment(@RequestBody Eveniment eveniment) {
        return evenimentRepository.save(eveniment);
    }

    @DeleteMapping("/id/{valoare_id}")
    public void deleteEveniment(@PathVariable Long valoare_id) {
        evenimentRepository.deleteById(valoare_id);
    }
}
