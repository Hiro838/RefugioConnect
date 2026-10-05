package refugio.connect.upc.refugioconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import refugio.connect.upc.refugioconnect.entities.Donacion;

import java.util.List;

@Repository
public interface IDonacionRepository extends JpaRepository<Donacion, Long> {

    @Query(value = "SELECT d.tipo_donacion, COUNT(d.id_donacion) " +
            "FROM donaciones d " +
            "GROUP BY d.tipo_donacion", nativeQuery = true)
    List<Object[]> getCantidadPorTipoDonacion();
}