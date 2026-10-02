package refugio.connect.upc.refugioconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import refugio.connect.upc.refugioconnect.entities.TurnosVoluntariados;

@Repository
public interface ITurnosVoluntariadosRepository extends JpaRepository<TurnosVoluntariados, Long> {
}