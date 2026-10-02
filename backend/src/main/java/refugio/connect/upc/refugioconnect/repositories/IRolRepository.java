package refugio.connect.upc.refugioconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import refugio.connect.upc.refugioconnect.entities.Rol;

import java.util.List;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Long> {

    @Query(value = "SELECT r.nombre_rol, COUNT(*) " +
            "FROM roles r " +
            "GROUP BY r.nombre_rol", nativeQuery = true)
    List<Object[]> countByNombreRol();
}
