package refugio.connect.upc.refugioconnect.servicesimplements;

import org.springframework.stereotype.Service;
import refugio.connect.upc.refugioconnect.entities.SeguimientoAdopcion;
import refugio.connect.upc.refugioconnect.repositories.ISeguimientoAdopcionRepository;
import refugio.connect.upc.refugioconnect.servicesinterfaces.ISeguimientoAdopcionService;

import java.util.List;
import java.util.Optional;

@Service
public class SeguimientoAdopcionServiceImplement implements ISeguimientoAdopcionService {

    private final ISeguimientoAdopcionRepository sR;

    public SeguimientoAdopcionServiceImplement(ISeguimientoAdopcionRepository sR) {
        this.sR = sR;
    }

    @Override
    public List<SeguimientoAdopcion> list() {
        return sR.findAll();
    }

    @Override
    public void insert(SeguimientoAdopcion s) {
        sR.save(s);
    }

    @Override
    public Optional<SeguimientoAdopcion> listId(Long id) {
        return sR.findById(id);
    }

    @Override
    public void delete(Long id) {
        sR.deleteById(id);
    }

    @Override
    public List<Object[]> countByEstadoMascota() {
        return sR.countByEstadoMascota();
    }
}