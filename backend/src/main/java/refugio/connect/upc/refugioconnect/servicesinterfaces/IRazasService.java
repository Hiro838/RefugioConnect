package refugio.connect.upc.refugioconnect.servicesinterfaces;

import refugio.connect.upc.refugioconnect.entities.Razas;

import java.util.List;
import java.util.Optional;

public interface IRazasService {
    public List<Razas> list();
    public void insert(Razas r);
    public Optional<Razas> listId(Long id);
    public void delete(Long id);
}
