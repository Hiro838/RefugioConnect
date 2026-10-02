package refugio.connect.upc.refugioconnect.servicesimplements;

import org.springframework.stereotype.Service;
import refugio.connect.upc.refugioconnect.entities.SolicitudAdopcion;
import refugio.connect.upc.refugioconnect.repositories.ISolicitudAdopcionRepository;
import refugio.connect.upc.refugioconnect.servicesinterfaces.ISolicitudAdopcionService;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudAdopcionServiceImplement implements ISolicitudAdopcionService {

    private final ISolicitudAdopcionRepository solicitudRepository;

    public SolicitudAdopcionServiceImplement(ISolicitudAdopcionRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    @Override
    public void insert(SolicitudAdopcion solicitudAdopcion) {
        solicitudRepository.save(solicitudAdopcion);
    }

    @Override
    public List<SolicitudAdopcion> list() {
        return solicitudRepository.findAll();
    }

    @Override
    public Optional<SolicitudAdopcion> listId(Long id) {
        return solicitudRepository.findById(id);
    }

    @Override
    public void update(SolicitudAdopcion solicitudAdopcion) {
        solicitudRepository.save(solicitudAdopcion);
    }

    @Override
    public void delete(Long id) {
        solicitudRepository.deleteById(id);
    }

    @Override
    public List<Object[]> obtenerTotalSolicitudesPorRolUsuario() {
        return solicitudRepository.getTotalSolicitudesPorRolUsuario();
    }
}