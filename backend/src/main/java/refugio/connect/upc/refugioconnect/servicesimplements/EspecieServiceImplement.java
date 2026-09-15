package refugio.connect.upc.refugioconnect.servicesimplements;

import org.springframework.stereotype.Service;
import refugio.connect.upc.refugioconnect.entities.Especie;
import refugio.connect.upc.refugioconnect.repositories.IEspecieRepository;
import refugio.connect.upc.refugioconnect.servicesinterfaces.IEspecieService;

import java.util.List;
import java.util.Optional;

@Service
public class EspecieServiceImplement implements IEspecieService {
    private final IEspecieRepository eR;

    public EspecieServiceImplement(IEspecieRepository eR) {
        this.eR = eR;
    }

    @Override
    public List<Especie> list() {
        return eR.findAll();
    }

    @Override
    public void insert(Especie e) {
        eR.save(e);
    }

    @Override
    public Optional<Especie> listId(Long id) {
        return eR.findById(id);
    }

    @Override
    public void delete(Long id) {
        eR.deleteById(id);
    }
}
