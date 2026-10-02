package refugio.connect.upc.refugioconnect.servicesimplements;

import org.springframework.stereotype.Service;
import refugio.connect.upc.refugioconnect.entities.SeguimientoAdopcion;
import refugio.connect.upc.refugioconnect.repositories.ISeguimientoAdopcionRepository;
import refugio.connect.upc.refugioconnect.servicesinterfaces.ISeguimientoAdopcionService;

import java.util.List;
import java.util.Optional;

@Service
public class SeguimientoAdopcionServiceImplement implements ISeguimientoAdopcionService {

    private final ISeguimientoAdopcionRepository seguimientoRepository;

    public SeguimientoAdopcionServiceImplement(ISeguimientoAdopcionRepository seguimientoRepository) {
        this.seguimientoRepository = seguimientoRepository;
    }

    @Override
    public void insert(SeguimientoAdopcion seguimientoAdopcion) {
        seguimientoRepository.save(seguimientoAdopcion);
    }

    @Override
    public List<SeguimientoAdopcion> list() {
        return seguimientoRepository.findAll();
    }

    @Override
    public Optional<SeguimientoAdopcion> listId(Long id) {
        return seguimientoRepository.findById(id);
    }

    @Override
    public void update(SeguimientoAdopcion seguimientoAdopcion) {
        seguimientoRepository.save(seguimientoAdopcion);
    }

    @Override
    public void delete(Long id) {
        seguimientoRepository.deleteById(id);
    }
}