package refugio.connect.upc.refugioconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import refugio.connect.upc.refugioconnect.entities.SolicitudAdopcion;

import java.util.List;

@Repository
public interface ISolicitudAdopcionRepository extends JpaRepository<SolicitudAdopcion, Long> {

    @Query(value = "SELECT s.estado_solicitud, COUNT(s.id_solicitud) " +
            "FROM solicitudes_adopcion s " +
            "GROUP BY s.estado_solicitud", nativeQuery = true)
    List<Object[]> countByEstadoSolicitud();
}