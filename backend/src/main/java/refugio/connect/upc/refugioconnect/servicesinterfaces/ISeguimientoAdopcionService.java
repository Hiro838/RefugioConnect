package refugio.connect.upc.refugioconnect.servicesinterfaces;

import refugio.connect.upc.refugioconnect.entities.SeguimientoAdopcion;

import java.util.List;
import java.util.Optional;

public interface ISeguimientoAdopcionService {

    public List<SeguimientoAdopcion> list();

    public void insert(SeguimientoAdopcion s);

    public Optional<SeguimientoAdopcion> listId(Long id);

    public void delete(Long id);

    List<Object[]> countByEstadoMascota();
}