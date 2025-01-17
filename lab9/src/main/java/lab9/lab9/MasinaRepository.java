package lab9.lab9;

import java.util.List;

public interface MasinaRepository<Masina> extends CrudRepository<Masina, String> {
    List<Masina> findByMarca(String marca);
    List<Masina> findByKmLessThan(int km);
    List<Masina> findByAnulFabricatieiGreaterThan(int anul);
}
