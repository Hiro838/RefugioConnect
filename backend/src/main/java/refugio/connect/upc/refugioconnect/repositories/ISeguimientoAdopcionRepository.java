package refugio.connect.upc.refugioconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import refugio.connect.upc.refugioconnect.entities.SeguimientoAdopcion;

import java.util.List;

@Repository
public interface ISeguimientoAdopcionRepository extends JpaRepository<SeguimientoAdopcion, Long> {

    @Query(value = "SELECT s.estado_mascota, COUNT(s.id_seguimiento) " +
            "FROM seguimientos_adopcion s " +
            "GROUP BY s.estado_mascota", nativeQuery = true)
    List<Object[]> countByEstadoMascota();
}