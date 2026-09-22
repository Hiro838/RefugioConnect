package refugio.connect.upc.refugioconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import refugio.connect.upc.refugioconnect.entities.Mascotas;

@Repository
public interface IMascotasRepository extends JpaRepository<Mascotas, Long> {
}
