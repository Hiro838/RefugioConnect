package refugio.connect.upc.refugioconnect.servicesimplements;

import org.springframework.stereotype.Service;
import refugio.connect.upc.refugioconnect.entities.SolicitudAdopcion;
import refugio.connect.upc.refugioconnect.repositories.ISolicitudAdopcionRepository;
import refugio.connect.upc.refugioconnect.servicesinterfaces.ISolicitudAdopcionService;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudAdopcionServiceImplement implements ISolicitudAdopcionService {

    private final ISolicitudAdopcionRepository sR;

    public SolicitudAdopcionServiceImplement(ISolicitudAdopcionRepository sR) {
        this.sR = sR;
    }

    @Override
    public List<SolicitudAdopcion> list() {
        return sR.findAll();
    }

    @Override
    public void insert(SolicitudAdopcion s) {
        sR.save(s);
    }

    @Override
    public Optional<SolicitudAdopcion> listId(Long id) {
        return sR.findById(id);
    }

    @Override
    public void delete(Long id) {
        sR.deleteById(id);
    }
}