package refugio.connect.upc.refugioconnect.servicesinterfaces;

import refugio.connect.upc.refugioconnect.entities.SolicitudAdopcion;

import java.util.List;
import java.util.Optional;

public interface ISolicitudAdopcionService {

    public void insert(SolicitudAdopcion solicitudAdopcion);

    public List<SolicitudAdopcion> list();

    public Optional<SolicitudAdopcion> listId(Long id);

    public void update(SolicitudAdopcion solicitudAdopcion);

    public void delete(Long id);

    public List<Object[]> obtenerTotalSolicitudesPorRolUsuario();
}