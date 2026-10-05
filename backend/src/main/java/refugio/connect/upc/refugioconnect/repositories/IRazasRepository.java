package refugio.connect.upc.refugioconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import refugio.connect.upc.refugioconnect.entities.Razas;

@Repository
public interface IRazasRepository extends JpaRepository<Razas, Long> {
}
