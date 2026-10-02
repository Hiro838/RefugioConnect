package refugio.connect.upc.refugioconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import refugio.connect.upc.refugioconnect.entities.Mascota;

import java.util.List;

@Repository
public interface IMascotaRepository extends JpaRepository<Mascota, Long> {

    @Query(value = "SELECT r.nombre_raza, COUNT(sa.id_solicitud_adopcion) " +
            "FROM razas r " +
            "INNER JOIN mascotas m ON r.id_raza = m.id_raza " +
            "INNER JOIN solicitudes_adopcion sa ON m.id_mascota = sa.id_mascota " +
            "GROUP BY r.id_raza, r.nombre_raza", nativeQuery = true)
    List<Object[]> getTotalSolicitudesPorRaza();
}
