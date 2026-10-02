package refugio.connect.upc.refugioconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import refugio.connect.upc.refugioconnect.entities.SolicitudAdopcion;

import java.util.List;

@Repository
public interface ISolicitudAdopcionRepository extends JpaRepository<SolicitudAdopcion, Long> {

    @Query(value = "SELECT r.nombre_rol, COUNT(sa.id_solicitud_adopcion) " +
            "FROM roles r " +
            "INNER JOIN usuario_roles ur ON r.id_rol = ur.rol_id " +
            "INNER JOIN usuario u ON ur.usuario_id = u.id " +
            "INNER JOIN solicitudes_adopcion sa ON u.id = sa.id_usuario " +
            "GROUP BY r.id_rol, r.nombre_rol", nativeQuery = true)
    List<Object[]> getTotalSolicitudesPorRolUsuario();
}