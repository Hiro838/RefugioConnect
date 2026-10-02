package refugio.connect.upc.refugioconnect.servicesimplements;

import org.springframework.stereotype.Service;
import refugio.connect.upc.refugioconnect.entities.Donacion;
import refugio.connect.upc.refugioconnect.repositories.IDonacionRepository;
import refugio.connect.upc.refugioconnect.servicesinterfaces.IDonacionService;

import java.util.List;
import java.util.Optional;

@Service
public class DonacionServiceImplement implements IDonacionService {

    private final IDonacionRepository dR;

    public DonacionServiceImplement(IDonacionRepository dR) {
        this.dR = dR;
    }

    @Override
    public List<Donacion> list() {
        return dR.findAll();
    }

    @Override
    public void insert(Donacion d) {
        dR.save(d);
    }

    @Override
    public Optional<Donacion> listId(Long id) {
        return dR.findById(id);
    }

    @Override
    public void delete(Long id) {
        dR.deleteById(id);
    }

    @Override
    public List<Object[]> getCantidadPorTipoDonacion() {
        return dR.getCantidadPorTipoDonacion();
    }
}