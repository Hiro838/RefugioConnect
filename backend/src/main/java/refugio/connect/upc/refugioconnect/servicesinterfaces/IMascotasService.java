package refugio.connect.upc.refugioconnect.servicesinterfaces;

import refugio.connect.upc.refugioconnect.entities.Mascotas;

import java.util.List;
import java.util.Optional;

public interface IMascotasService {
    public List<Mascotas> list();
    public void insert(Mascotas m);
    public Optional<Mascotas> listId(Long id);
    public void delete(Long id);
}
