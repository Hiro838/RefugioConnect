package refugio.connect.upc.refugioconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import refugio.connect.upc.refugioconnect.entities.Donaciones;

@Repository
public interface IDonacionesRepository extends JpaRepository<Donaciones, Long> {
}