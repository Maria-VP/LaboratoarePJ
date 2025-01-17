package laborator9.ex2.laborator9.ex2;

import java.util.List;
import java.util.Optional;

public interface MasinaRepository extends CrudRepository<Masina, String> {
    @Query("SELECT * FROM masini WHERE marca = :marca")
    List<Masina> findByMarca(String marca);

    @Query("SELECT * FROM masini WHERE km < 100000")
    List<Masina> findByKmLessThan100000();

    @Query("SELECT * FROM masini WHERE anul_fabricatiei > YEAR(CURDATE()) - 5")
    List<Masina> findMasiniNoi();

    Masina save(Masina masina);

    void deleteById(String numarInmatriculare);

    Object findAll();

    Optional<Masina> findById(String numarInmatriculare);
}
