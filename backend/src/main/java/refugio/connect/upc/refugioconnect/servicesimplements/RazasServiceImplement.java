package refugio.connect.upc.refugioconnect.servicesimplements;

import org.springframework.stereotype.Service;
import refugio.connect.upc.refugioconnect.entities.Razas;
import refugio.connect.upc.refugioconnect.repositories.IRazasRepository;
import refugio.connect.upc.refugioconnect.servicesinterfaces.IRazasService;

import java.util.List;
import java.util.Optional;

@Service
public class RazasServiceImplement implements IRazasService {

    private final IRazasRepository raR;

    public RazasServiceImplement(IRazasRepository raR) {
        this.raR = raR;
    }

    @Override
    public List<Razas> list() {
        return raR.findAll();
    }

    @Override
    public void insert(Razas ra) {
        raR.save(ra);
    }

    @Override
    public Optional<Razas> listId(Long id)  {
        return raR.findById(id);
    }

    @Override
    public void delete(Long id)  {
        raR.deleteById(id);
    }
}
