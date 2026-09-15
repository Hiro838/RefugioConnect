package refugio.connect.upc.refugioconnect.servicesinterfaces;

import refugio.connect.upc.refugioconnect.entities.Rol;

import java.util.List;
import java.util.Optional;

public interface IRolService {
    public List<Rol>list();
    public void insert(Rol r);
    public Optional<Rol>listId(Long id);
    public void delete(Long id);
}
