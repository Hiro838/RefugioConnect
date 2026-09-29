package refugio.connect.upc.refugioconnect.servicesinterfaces;

import refugio.connect.upc.refugioconnect.entities.SolicitudAdopcion;

import java.util.List;
import java.util.Optional;

public interface ISolicitudAdopcionService {

    public List<SolicitudAdopcion> list();

    public void insert(SolicitudAdopcion s);

    public Optional<SolicitudAdopcion> listId(Long id);

    public void delete(Long id);
}