package laborator9.ex3.laborator9.ex3;

public interface MasinaRepository extends CrudRepository<Masina, String>{
    @Query("SELECT * FROM masini WHERE marca = :marca")
    List<Masina> findByMarca(String marca);

    @Query("SELECT COUNT(*) FROM masini WHERE km < 100000")
    int countByKmLessThan100000();

    @Query("SELECT * FROM masini WHERE anul_fabricatiei > YEAR(CURDATE()) - 5")
    List<Masina> findMasiniNoi();
}
