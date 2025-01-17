package laborator10.laborator10;

import java.util.List;

@Repository
public interface CarteRepository extends JpaRepository<Carte, Long> {

    void save(Carte carte);

    List<Carte> findAll();

    void delete(Carte carte);
}
