package laborator10.laborator10;

import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CarteWebController {

    @Autowired
    private CarteRepository carteRepository;

    @GetMapping("/lista-carti")
    public String listaCarti(Model model) {
        List<Carte> carti = carteRepository.findAll();
        model.addAttribute("carti", carti);
        return "carti";
    }

    @PostMapping("/operatii")
    public String operatiiCarti(
            @RequestParam(required = false) String isbn,
            @RequestParam(required = false) String titlu,
            @RequestParam(required = false) String autor,
            @RequestParam(required = false) Integer anPublicatie,
            @RequestParam(required = false) String adauga,
            @RequestParam(required = false) String sterge,
            Model model) {

        String mesaj = "";

        if (adauga != null) {
            Carte carte = new Carte();
            carte.setIsbn(isbn);
            carte.setTitlu(titlu);
            carte.setAutor(autor);
            carte.setAnPublicatie(anPublicatie);
            carteRepository.save(carte);
            mesaj = "Cartea a fost adăugată cu succes!";
        } else if (sterge != null) {
            List<Carte> carti = carteRepository.findAll();
            for (Carte carte : carti) {
                if (carte.getIsbn().equals(isbn)) {
                    carteRepository.delete(carte);
                    mesaj = "Cartea a fost ștearsă!";
                    break;
                }
            }
        }

        model.addAttribute("carti", carteRepository.findAll());
        model.addAttribute("mesaj", mesaj);
        return "carti";
    }
}
