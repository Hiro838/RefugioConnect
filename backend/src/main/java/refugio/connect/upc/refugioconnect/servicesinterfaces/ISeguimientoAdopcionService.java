package refugio.connect.upc.refugioconnect.servicesinterfaces;

import refugio.connect.upc.refugioconnect.entities.SeguimientoAdopcion;

import java.util.List;
import java.util.Optional;

public interface ISeguimientoAdopcionService {

    public void insert(SeguimientoAdopcion seguimientoAdopcion);

    public List<SeguimientoAdopcion> list();

    public Optional<SeguimientoAdopcion> listId(Long id);

    public void update(SeguimientoAdopcion seguimientoAdopcion);

    public void delete(Long id);
}